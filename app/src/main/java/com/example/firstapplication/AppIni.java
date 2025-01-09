
package com.example.firstapplication;
import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.room.Room;
import com.example.firstapplication.db.CityWeatherApi;
import com.example.firstapplication.db.CityWeather;
import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserWeatherCrossRef;
import com.example.firstapplication.db.Weather;
import java.util.List;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class AppIni extends Application {
    public static AppIni instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        // Заполнение базы данных пользователями и погодой
        initializeDatabase();
    }

    public static AppIni getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    private void initializeDatabase() {
        List<User> users = database.userDao().getAllUsers();
        List<Weather> weathers = database.weatherDao().getAllWeathers();
        if (users.size() >= 5 && weathers.size() >= 5) {
            return; // Если пользователи и погода уже есть, выходим
        }

        // Очистка базы данных
        database.userDao().deleteAllUsersWithWeather();
        database.userDao().deleteAllUsers();
        database.weatherDao().deleteAllWeathers();

        // Заполнение данными
        Resources resources = getResources();
        String[] email = resources.getStringArray(R.array.Emailarr);
        String[] password = resources.getStringArray(R.array.Passarr);
        for (int i = 0; i < email.length; i++) {
            User user = new User();
            user.email = email[i];
            user.password = password[i];
            database.userDao().insertUser (user);
        }

        // Получение данных о погоде
        fetchWeatherData();
    }

    private void fetchWeatherData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CityWeatherApi weatherApi = retrofit.create(CityWeatherApi.class);
        Call<List<CityWeather>> weatherCall = weatherApi.getWeatherList();
        weatherCall.enqueue(new Callback<List<CityWeather>>() {
            @Override
            public void onResponse(Call<List<CityWeather>> call, Response<List<CityWeather>> response) {
                List<CityWeather> weatherDtoList = response.body();
                if (weatherDtoList != null) {
                    for (CityWeather cityWeather : weatherDtoList) {
                        Weather weather = new Weather();
                        weather.city = cityWeather.getCity();
                        weather.condition = cityWeather.getWeatherCondition();
                        weather.pressure = cityWeather.getAtmosphericPressure();
                        weather.temp = cityWeather.getTemperature();
                        weather.wind = cityWeather.getWind();
                        database.weatherDao().insert(weather);
                    }
                }
                populateUserWeatherCrossRefs();
            }

            @Override
            public void onFailure(Call<List<CityWeather>> call, Throwable throwable) {
                Log.e("weatherError", throwable.getMessage());
            }
        });
    }

    private void populateUserWeatherCrossRefs() {
        Random random = new Random();
        List<User> users = database.userDao().getAllUsers();
        List<Weather> weathers = database.weatherDao().getAllWeathers();
        for (User  user : users) {
            for (int j = 0; j < 3; j++) {
                UserWeatherCrossRef userWeatherCrossRef = new UserWeatherCrossRef();
                userWeatherCrossRef.userId = user.userId;
                userWeatherCrossRef.weatherId = weathers.get(random.nextInt(weathers.size())).weatherId;
                database.userDao().insertUserWithWeather(userWeatherCrossRef);
            }
        }
    }
}

package com.example.firstapplication;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserDao;
import com.example.firstapplication.db.UserWeatherCrossRef;
import com.example.firstapplication.db.Weather;
import com.example.firstapplication.db.WeatherDao;

@Database(entities = {Weather.class, User.class, UserWeatherCrossRef.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();
    public abstract UserDao userDao();
}
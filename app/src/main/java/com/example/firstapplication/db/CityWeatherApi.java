
package com.example.firstapplication.db;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface CityWeatherApi {
    @GET("/Lpirskaya/JsonLab/master/Weather2022.json")
    Call<List<CityWeather>> getWeatherList();
}

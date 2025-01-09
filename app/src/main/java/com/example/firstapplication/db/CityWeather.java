
package com.example.firstapplication.db;
import com.google.gson.annotations.SerializedName;

public class CityWeather {
    @SerializedName("City")
    private String City;
    @SerializedName("AtmosphericPressure")
    private Integer AtmosphericPressure;
    @SerializedName("Temperature")
    private Integer Temperature;
    @SerializedName("WeatherCondition")
    private String WeatherCondition;
    @SerializedName("Wind")
    private Integer Wind;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Integer getAtmosphericPressure() {
        return AtmosphericPressure;
    }

    public void setAtmosphericPressure(Integer atmosphericPressure) {
        AtmosphericPressure = atmosphericPressure;
    }

    public Integer getTemperature() {
        return Temperature;
    }

    public void setTemperature(Integer temperature) {
        Temperature = temperature;
    }

    public String getWeatherCondition() {
        return WeatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        WeatherCondition = weatherCondition;
    }

    public Integer getWind() {
        return Wind;
    }

    public void setWind(Integer wind) {
        Wind = wind;
    }
}
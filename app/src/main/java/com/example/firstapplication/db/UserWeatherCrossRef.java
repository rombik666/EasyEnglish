package com.example.firstapplication.db;
import androidx.room.Entity;

@Entity(primaryKeys = {"userId","weatherId"})
public class UserWeatherCrossRef {
    public long userId;
    public long weatherId;
}
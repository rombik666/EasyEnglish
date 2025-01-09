
package com.example.firstapplication;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.firstapplication.db.Question;
import com.example.firstapplication.db.QuestionDao;
import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserDao;
import com.example.firstapplication.db.UserWeatherCrossRef;
import com.example.firstapplication.db.Weather;
import com.example.firstapplication.db.WeatherDao;

@Database(entities = {Weather.class, User.class, UserWeatherCrossRef.class, Question.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WeatherDao weatherDao();
    public abstract UserDao userDao();
    public abstract QuestionDao questionDao();
}




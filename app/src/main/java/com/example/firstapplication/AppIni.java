package com.example.firstapplication;

import android.app.Application;
import android.content.res.Resources;

import androidx.room.Room;

import com.example.firstapplication.db.Question;
import com.example.firstapplication.db.QuestionDao;
import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserDao;
import com.example.firstapplication.db.Weather;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppIni extends Application {
    public static AppIni instance;
    private AppDatabase database;

    // ExecutorService для фоновых операций
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // Инициализация базы данных
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries() // Только временно, для тестирования
                .build();

        // Заполнение базы данных
        executorService.execute(() -> initializeDatabase());
    }

    public static AppIni getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    private void initializeDatabase() {
        // Заполнение таблицы пользователей (пример)
        UserDao userDao = database.userDao();
        if (userDao.getAllUsers().isEmpty()) {
            Resources resources = getResources();
            String[] email = resources.getStringArray(R.array.Emailarr);
            String[] password = resources.getStringArray(R.array.Passarr);
            for (int i = 0; i < email.length; i++) {
                User user = new User();
                user.email = email[i];
                user.password = password[i];
                userDao.insertUser(user);
            }
        }

        // Заполнение таблицы вопросов
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Здесь будет реализовано рандомное добавление вопросов с помощью БД
    }
}

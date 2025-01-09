package com.example.firstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserDao;
import com.example.firstapplication.db.UserWithCity;
import com.example.firstapplication.db.Weather;

import java.util.List;

public class MainActivity12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main12);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
                EditText passwordEditText = findViewById(R.id.editTextNumberPassword); // Исправлено на правильный ID
                boolean isEmailCorrect = false;
                boolean isPasswordCorrect = false;

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                AppDatabase db = AppIni.getInstance().getDatabase();
                UserDao userDao = db.userDao();
                User user = userDao.getUserByEmail(email);

                if (user != null) {
                    isEmailCorrect = true;
                    isPasswordCorrect = user.password.equals(password);
                }

                if (isEmailCorrect && isPasswordCorrect) {
                    emailEditText.setTextColor(Color.BLACK);
                    passwordEditText.setTextColor(Color.BLACK);
                    UserWithCity userWithCity = db.userDao().getUserWithWeatherByEmail(user.email);
                    List<Weather> weatherList = userWithCity.weathers;
                    for (Weather weather : weatherList) {
                        Log.i("userWeather", user.email + ": " + weather.city);
                    }
                    Intent myIntent = new Intent(MainActivity12.this, MainActivity2.class); // Используем правильный контекст
                    myIntent.putExtra("userEmail", user.email);
                    myIntent.putExtra("userId", user.userId);
                    startActivity(myIntent);
                }else {
                    emailEditText.setTextColor(Color.RED);
                    passwordEditText.setTextColor(Color.RED);
                }
            }
        });

        Button registerButton = findViewById(R.id.button_register); // ID кнопки из XML
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity12.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.db.User;
import com.example.firstapplication.db.UserDao;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Убедитесь, что у вас есть макет activity_register.xml

        EditText emailEditText = findViewById(R.id.editTextRegisterEmail); // Используйте ID из вашего макета
        EditText passwordEditText = findViewById(R.id.editTextRegisterPassword); // Используйте ID из вашего макета
        Button registerButton = findViewById(R.id.buttonRegister); // Используйте ID из вашего макета

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Пожалуйста, заполните все поля!", Toast.LENGTH_SHORT).show();
                    return;
                }

                AppDatabase db = AppIni.getInstance().getDatabase();
                UserDao userDao = db.userDao();

                // Проверяем, есть ли пользователь с таким email
                User existingUser = userDao.getUserByEmail(email);
                if (existingUser != null) {
                    Toast.makeText(RegisterActivity.this, "Пользователь с таким email уже существует!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Создаем нового пользователя и добавляем его в базу данных
                User newUser = new User();
                newUser.email = email;
                newUser.password = password;

                userDao.insertUser(newUser);

                Toast.makeText(RegisterActivity.this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();

                // Переход к экрану входа
                Intent intent = new Intent(RegisterActivity.this, MainActivity12.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
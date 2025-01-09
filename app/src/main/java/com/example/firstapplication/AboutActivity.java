package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Устанавливаем текст информации об приложении
        TextView aboutTextView = findViewById(R.id.about_text);
        aboutTextView.setText("Приложение 'EasyEnglish'\n" +
                "Разработчик: Кудинов Максим Андреевич\n\n" +
                "Это приложение предназначено для изучения английского языка " +
                "с помощью теоретических материалов и тестов. Спасибо, что используете наше приложение!");

        Button backToHomeButton = findViewById(R.id.button_back);
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, MainActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        }
    }
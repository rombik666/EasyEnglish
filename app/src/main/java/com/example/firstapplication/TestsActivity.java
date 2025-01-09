package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TestsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Button easyButton = findViewById(R.id.button_easy);
        Button mediumButton = findViewById(R.id.button_medium);
        Button hardButton = findViewById(R.id.button_hard);

        easyButton.setOnClickListener(v -> openTest("easy"));
        mediumButton.setOnClickListener(v -> openTest("medium"));
        hardButton.setOnClickListener(v -> openTest("hard"));
    }

    private void openTest(String level) {
        Intent intent = new Intent(TestsActivity.this, TestActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
    }
}

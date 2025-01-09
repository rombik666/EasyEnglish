package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Button easyButton = findViewById(R.id.button_easy);
        Button mediumButton = findViewById(R.id.button_medium);
        Button hardButton = findViewById(R.id.button_hard);

        easyButton.setOnClickListener(v -> openTest(TestsData.getEasyLevelQuestions()));
        mediumButton.setOnClickListener(v -> openTest(TestsData.getMediumLevelQuestions()));
        hardButton.setOnClickListener(v -> openTest(TestsData.getHardLevelQuestions()));
    }

    private void openTest(List<TestQuestion> questions) {
        Intent intent = new Intent(TestsActivity.this, TestActivity.class);
        intent.putParcelableArrayListExtra("questions", new ArrayList<>(questions));
        startActivity(intent);
    }
}
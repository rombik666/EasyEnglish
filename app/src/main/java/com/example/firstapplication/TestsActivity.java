package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        Button backToHomeButton = findViewById(R.id.button_back);
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestsActivity.this, MainActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openTest(List<TestQuestion> questions) {
        Intent intent = new Intent(TestsActivity.this, TestActivity.class);
        intent.putParcelableArrayListExtra("questions", new ArrayList<>(questions));
        startActivity(intent);
    }
}
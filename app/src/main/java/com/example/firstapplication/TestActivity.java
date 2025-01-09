package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private List<TestQuestion> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private TextView questionTextView;
    private RadioGroup optionsGroup;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questions = getIntent().getParcelableArrayListExtra("questions");

        questionTextView = findViewById(R.id.question_text);
        optionsGroup = findViewById(R.id.options_group);
        nextButton = findViewById(R.id.next_button);

        loadQuestion();

        nextButton.setOnClickListener(v -> {
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedOption = findViewById(selectedId);
                int selectedIndex = optionsGroup.indexOfChild(selectedOption);
                if (selectedIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    loadQuestion();
                } else {
                    showResults(score, questions.size());
                }
            }
        });
    }

    private void loadQuestion() {
        TestQuestion question = questions.get(currentQuestionIndex);
        questionTextView.setText(question.getQuestion());
        optionsGroup.removeAllViews();
        for (String option : question.getOptions()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            optionsGroup.addView(radioButton);
        }
    }

    private void showResults(int correctAnswers, int totalQuestions) {
        Intent intent = new Intent(TestActivity.this, TestResultsActivity.class);
        intent.putExtra("correctAnswers", correctAnswers);
        intent.putExtra("totalQuestions", totalQuestions);
        startActivity(intent);
        finish();
    }
}
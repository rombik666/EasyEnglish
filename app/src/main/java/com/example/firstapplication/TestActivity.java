package com.example.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    private List<TestQuestion> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Определяем уровень сложности
        String level = getIntent().getStringExtra("level");
        if (level != null) {
            switch (level) {
                case "easy":
                    questions = TestsData.getEasyLevelQuestions();
                    break;
                case "medium":
                    questions = TestsData.getMediumLevelQuestions();
                    break;
                case "hard":
                    questions = TestsData.getHardLevelQuestions();
                    break;
            }
        }

        showQuestion();
    }

    private void showQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            Toast.makeText(this, "Вы завершили тест! Ваши баллы: " + score, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        TestQuestion question = questions.get(currentQuestionIndex);

        TextView questionText = findViewById(R.id.question_text);
        questionText.setText(question.getQuestion());

        RadioGroup optionsGroup = findViewById(R.id.options_group);
        optionsGroup.removeAllViews();

        if (question.getOptions() != null) {
            // Выбор варианта
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(options.get(i));
                radioButton.setId(i);
                optionsGroup.addView(radioButton);
            }
        } else {
            // Текстовый ввод
            findViewById(R.id.text_input).setVisibility(View.VISIBLE);
        }

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> checkAnswer());
    }

    private void checkAnswer() {
        TestQuestion question = questions.get(currentQuestionIndex);

        if (question.getOptions() != null) {
            RadioGroup optionsGroup = findViewById(R.id.options_group);
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Выберите вариант ответа!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedId == (int) question.getCorrectAnswer()) {
                score++;
                Toast.makeText(this, "Ответ верный!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ответ неверный!", Toast.LENGTH_SHORT).show();
            }
        } else {
            String userInput = ((TextView) findViewById(R.id.text_input)).getText().toString();
            if (userInput.equalsIgnoreCase((String) question.getCorrectAnswer())) {
                score++;
                Toast.makeText(this, "Ответ верный!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ответ неверный!", Toast.LENGTH_SHORT).show();
            }
        }

        currentQuestionIndex++;
        showQuestion();
    }
}
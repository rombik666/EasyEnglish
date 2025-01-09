package com.example.firstapplication;

import java.util.List;

public class TestQuestion {
    private String question; // Вопрос
    private List<String> options; // Варианты ответов (может быть null для ввода текста)
    private Object correctAnswer; // Правильный ответ (индекс или строка)

    public TestQuestion(String question, List<String> options, Object correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public Object getCorrectAnswer() {
        return correctAnswer;
    }
}
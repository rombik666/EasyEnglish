package com.example.firstapplication;

import java.util.Arrays;
import java.util.List;

public class TestsData {

    public static List<TestQuestion> getEasyLevelQuestions() {
        return Arrays.asList(
                new TestQuestion(
                        "Как переводится слово \"cat\"?",
                        Arrays.asList("Собака", "Кошка", "Лиса"),
                        1 // Индекс правильного ответа
                )
        );
    }

    public static List<TestQuestion> getMediumLevelQuestions() {
        return Arrays.asList(
                new TestQuestion(
                        "Выберите правильное предложение в Present Continuous.",
                        Arrays.asList("She reads a book.", "She is reading a book.", "She read a book."),
                        1 // Индекс правильного ответа
                )
        );
    }

    public static List<TestQuestion> getHardLevelQuestions() {
        return Arrays.asList(
                new TestQuestion(
                        "Напишите перевод предложения \"The weather is nice today.\"",
                        null, // Для текстового ввода варианты не нужны
                        "Сегодня хорошая погода." // Правильный ответ
                )
        );
    }
}
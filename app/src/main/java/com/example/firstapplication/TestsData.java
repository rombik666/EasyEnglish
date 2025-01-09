package com.example.firstapplication;

import java.util.ArrayList;
import java.util.List;

public class TestsData {

    public static List<TestQuestion> getEasyLevelQuestions() {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion("Как переводится слово 'cat'?", new String[]{"Кошка", "Собака", "Лиса"}, 0));
        questions.add(new TestQuestion("Как переводится слово 'dog'?", new String[]{"Кошка", "Собака", "Лиса"}, 1));
        questions.add(new TestQuestion("Как переводится слово 'fox'?", new String[]{"Кошка", "Собака", "Лиса"}, 2));
        questions.add(new TestQuestion("Как переводится слово 'bird'?", new String[]{"Птица", "Слон", "Кит"}, 0));
        questions.add(new TestQuestion("Как переводится слово 'elephant'?", new String[]{"Птица", "Слон", "Кит"}, 1));
        return questions;
    }

    public static List<TestQuestion> getMediumLevelQuestions() {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion("Выберите правильное предложение.", new String[]{"She reading a book", "She reads a book", "She is reading a book"}, 2));
        questions.add(new TestQuestion("Выберите правильное время.", new String[]{"I go to school", "I am going to school", "I gone to school"}, 1));
        questions.add(new TestQuestion("Какой перевод правильный?", new String[]{"I have a dog", "I am have a dog", "I had a dog"}, 0));
        questions.add(new TestQuestion("Укажите правильное отрицание.", new String[]{"I not like it", "I don't like it", "I doesn't like it"}, 1));
        questions.add(new TestQuestion("Укажите правильный вопрос.", new String[]{"He likes it?", "Does he like it?", "Do he likes it?"}, 1));
        return questions;
    }

    public static List<TestQuestion> getHardLevelQuestions() {
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion("Что означает идиома 'Break the ice'?", new String[]{"Начать разговор", "Сломать лёд", "Перейти на ты"}, 0));
        questions.add(new TestQuestion("Что означает идиома 'Hit the sack'?", new String[]{"Лечь спать", "Ударить мешок", "Сдаться"}, 0));
        questions.add(new TestQuestion("Какой перевод правильный?", new String[]{"It's raining cats and dogs", "It's raining cats and foxes", "It's raining cats and birds"}, 0));
        questions.add(new TestQuestion("Что означает фраза 'Piece of cake'?", new String[]{"Просто", "Кусочек торта", "Сложно"}, 0));
        questions.add(new TestQuestion("Что означает фраза 'Burning the midnight oil'?", new String[]{"Работать по ночам", "Гореть ночью", "Пропустить ночь"}, 0));
        return questions;
    }
}
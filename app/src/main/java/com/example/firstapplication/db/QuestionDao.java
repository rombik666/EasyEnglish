package com.example.firstapplication.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert
    void insertQuestion(Question question);

    @Query("SELECT * FROM questions WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT 5")
    List<Question> getRandomQuestions(String difficulty); // Выбирает 5 случайных вопросов по сложности

    @Query("DELETE FROM questions")
    void deleteAllQuestions();
}
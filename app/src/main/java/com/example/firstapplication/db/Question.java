package com.example.firstapplication.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String correctAnswer;
    public String difficulty; // Уровень сложности: "easy", "medium", "hard"
}

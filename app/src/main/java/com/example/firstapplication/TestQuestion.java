package com.example.firstapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class TestQuestion implements Parcelable {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public TestQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Parcelable implementation
    protected TestQuestion(Parcel in) {
        question = in.readString();
        options = in.createStringArray();
        correctAnswerIndex = in.readInt();
    }

    public static final Creator<TestQuestion> CREATOR = new Creator<TestQuestion>() {
        @Override
        public TestQuestion createFromParcel(Parcel in) {
            return new TestQuestion(in);
        }

        @Override
        public TestQuestion[] newArray(int size) {
            return new TestQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringArray(options);
        dest.writeInt(correctAnswerIndex);
    }
}
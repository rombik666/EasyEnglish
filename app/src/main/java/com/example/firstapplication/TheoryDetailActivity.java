package com.example.firstapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TheoryDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_detail);

        int topicIndex = getIntent().getIntExtra("topic_index", 0);
        String[] topics = getResources().getStringArray(R.array.theory_topics);
        String[] details = getResources().getStringArray(R.array.theory_details);

        TextView title = findViewById(R.id.theory_title);
        TextView content = findViewById(R.id.theory_content);

        title.setText(topics[topicIndex]);
        content.setText(details[topicIndex]);
    }
}
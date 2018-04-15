package com.example.rebosura.hslmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rebosura on 3/4/2018.
 */

public class QuizActivity extends AppCompatActivity{

    private TextView tvDifficultyLabel;
    private Button btnStartQuiz, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvDifficultyLabel = (TextView)findViewById(R.id.tvDifficultyLabel);
        btnStartQuiz = (Button)findViewById(R.id.btnStartQuiz);

        Intent i  = getIntent();
        int quizDifficulty = i.getIntExtra(QuizSelectorActivity.TOPIC_NUMBER, 0);
        switch (quizDifficulty){
            case 1:
                tvDifficultyLabel.setText("Beginner Level Quiz");
                btnStartQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(QuizActivity.this, EasyQuizActivity.class));
                    }
                });
                break;
            case 2:
                tvDifficultyLabel.setText("Intermediate Level Quiz");
                btnStartQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(QuizActivity.this, IntermediateQuizActivity.class));
                    }
                });
                break;
            case 3:
                tvDifficultyLabel.setText("Advanced Level Quiz");
                btnStartQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(QuizActivity.this, AdvancedQuizActivity.class));
                    }
                });
                break;
        }
    }
}

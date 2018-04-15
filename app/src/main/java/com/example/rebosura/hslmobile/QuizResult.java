package com.example.rebosura.hslmobile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rebosura on 3/8/2018.
 */

public class QuizResult extends AppCompatActivity{


    private int score;
    private TextView tvScore;
    public SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        tvScore = (TextView)findViewById(R.id.tvScore);

        Intent i = getIntent();
        int difficultyAdvanced = i.getIntExtra(AdvancedQuizActivity.DIFFICULTY, 0);
        int difficultyEasy = i.getIntExtra(EasyQuizActivity.easyDifficulty, 0);

        switch (difficultyAdvanced){
            case 3:
                sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
                score = sharedPref.getInt("advancedScore", 0);
                tvScore.setText(score+"");
            break;
        }

        switch(difficultyEasy){
            case 1:
                sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
                score = sharedPref.getInt("userScore", 0);
                tvScore.setText(score+"");
        }

    }
}
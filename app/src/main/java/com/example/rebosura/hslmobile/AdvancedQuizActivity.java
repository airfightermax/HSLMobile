package com.example.rebosura.hslmobile;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Rebosura on 3/4/2018.
 */

public class AdvancedQuizActivity extends AppCompatActivity{

    public static final String DIFFICULTY = "difficulty";
    QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private int mQuestionNumber = 0;
    private int score = 0;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    private TextView tvQuestion, tvCurrentPage;
    private String answer;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_quiz);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        btnOption1 = (Button)findViewById(R.id.btnOption1);
        btnOption2 = (Button)findViewById(R.id.btnOption2);
        btnOption3 = (Button)findViewById(R.id.btnOption3);
        btnOption4 = (Button)findViewById(R.id.btnOption4);
        tvQuestion = (TextView)findViewById(R.id.tvQuestion);
        tvCurrentPage = (TextView)findViewById(R.id.tvCurrentPage);
        sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = sharedPref.edit();

        updateQuestions();


        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnOption1.getText().toString().equals(answer)){
                    updateScore();
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnOption2.getText().toString().equals(answer)){
                    updateScore();
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnOption3.getText().toString().equals(answer)){
                    updateScore();
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnOption4.getText().toString().equals(answer)){
                    updateScore();
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

    }

    private void updateQuestions(){
        if(mQuestionNumber < mQuestionLibrary.getLength()){
            tvQuestion.setText(mQuestionLibrary.getAdvancedQuestions(mQuestionNumber));
            btnOption1.setText(mQuestionLibrary.getAdvancedChoices(mQuestionNumber, 0));
            btnOption2.setText(mQuestionLibrary.getAdvancedChoices(mQuestionNumber, 1));
            btnOption3.setText(mQuestionLibrary.getAdvancedChoices(mQuestionNumber, 2));
            btnOption4.setText(mQuestionLibrary.getAdvancedChoices(mQuestionNumber, 3));
            tvCurrentPage.setText((mQuestionNumber+1)+"");
            answer = mQuestionLibrary.getAdvancedAnswers(mQuestionNumber);
            mQuestionNumber++;
        }
        else{
            Toast.makeText(AdvancedQuizActivity.this, "Quiz Completed", Toast.LENGTH_SHORT);
            editor.putInt("advancedScore", score);
            editor.apply();
            Intent i = new Intent(AdvancedQuizActivity.this, QuizResult.class);
            i.putExtra(DIFFICULTY, 3);
            startActivity(i);
        }
    }
    public void updateScore(){
        score++;
    }
}

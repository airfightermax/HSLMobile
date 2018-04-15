package com.example.rebosura.hslmobile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rebosura on 3/4/2018.
 */

public class EasyQuizActivity extends AppCompatActivity{

    public static final String easyDifficulty = "easy_difficulty";
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mtvQuestion, mtvCurrentPage;
    private ImageView mivQuestion;
    private Button btnBack, mbtnOption1, mbtnOption2, mbtnOption3, mbtnOption4;
    private String mAnswer;
    private int score = 0;
    private int mQuestionNumber = 0;
    public SharedPreferences sharedPref;
    public SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_quiz);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



        mtvQuestion = (TextView)findViewById(R.id.tvQuestion);
        mtvCurrentPage = (TextView)findViewById(R.id.tvCurentPage);
        mivQuestion = (ImageView)findViewById(R.id.ivQuestion);
        mbtnOption1 = (Button)findViewById(R.id.btnOption1);
        mbtnOption2 = (Button)findViewById(R.id.btnOption2);
        mbtnOption3 = (Button)findViewById(R.id.btnOption3);
        mbtnOption4 = (Button)findViewById(R.id.btnOption4);
        btnBack = (Button)findViewById(R.id.btnBack);
        sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = sharedPref.edit();
        updateQuestion();


        mbtnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbtnOption1.getText().toString().equals(mAnswer)){
                    updateScore();
                    updateQuestion();
                }
                else{
                    updateQuestion();
                }
            }
        });
        mbtnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbtnOption2.getText().toString().equals(mAnswer)){
                    updateScore();
                    updateQuestion();
                }
                else{
                    updateQuestion();
                }
            }
        });
        mbtnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbtnOption3.getText().toString().equals(mAnswer)){
                    updateScore();
                    updateQuestion();
                }
                else{
                    updateQuestion();
                }
            }
        });
        mbtnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbtnOption4.getText().toString().equals(mAnswer)){
                    updateScore();
                    updateQuestion();
                }
                else{
                    updateQuestion();
                }
            }
        });
    }

    private void updateQuestion(){
        if(mQuestionNumber < mQuestionLibrary.getLength()){
            mtvQuestion.setText(mQuestionLibrary.getQuestions(mQuestionNumber));
            mbtnOption1.setText(mQuestionLibrary.getchoices(mQuestionNumber,0));
            mbtnOption2.setText(mQuestionLibrary.getchoices(mQuestionNumber,1));
            mbtnOption3.setText(mQuestionLibrary.getchoices(mQuestionNumber,2));
            mbtnOption4.setText(mQuestionLibrary.getchoices(mQuestionNumber,3));
            mivQuestion.setImageDrawable(getResources().getDrawable(mQuestionLibrary.getEasyImages(mQuestionNumber)));
            mAnswer = mQuestionLibrary.getAnswers(mQuestionNumber);
            mtvCurrentPage.setText((mQuestionNumber+1) + "");
            mQuestionNumber++;
        }
        else{
            Toast.makeText(EasyQuizActivity.this,"Quiz Completed", Toast.LENGTH_SHORT).show();
            editor.putInt("userScore", score);
            editor.apply();
            Intent i = new Intent(EasyQuizActivity.this, QuizResult.class);
            i.putExtra(easyDifficulty, 1);
            startActivity(i);
        }
    }
    private void updateScore(){
        score++;
    }
}

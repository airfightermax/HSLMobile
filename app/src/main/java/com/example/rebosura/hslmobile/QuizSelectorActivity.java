package com.example.rebosura.hslmobile;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rebosura on 3/4/2018.
 */

public class QuizSelectorActivity extends AppCompatActivity{

    public static final String TOPIC_NUMBER = "topic_number";
    private CardView btnBeginner, btnIntermediate, btnAdvanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_a);
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            transition.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setExitTransition(transition);
        }
        setContentView(R.layout.activity_quiz_selector);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void startQuiz(View view){
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(QuizSelectorActivity.this, null);
        Intent i = new Intent(QuizSelectorActivity.this, QuizActivity.class);
        switch(view.getId()){
            case R.id.btnBeginner:
                i.putExtra(TOPIC_NUMBER, 1);
                break;
            case R.id.btnIntermediate:
                i.putExtra(TOPIC_NUMBER, 2);
                break;
            case R.id.btnAdvanced:
                i.putExtra(TOPIC_NUMBER, 3);
                break;
        }
        startActivity(i, options.toBundle());
    }
}

package com.example.rebosura.hslmobile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

/**
 * Created by Rebosura on 3/21/2018.
 */

public class AnimalSelectorActivity extends AppCompatActivity{

    public static final String ANIMAL_ID = "animal_id";
    private CardView btnBird, btnCat, btnDeer, btnDog, btnGiraffe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            Slide slide = new Slide();
            slide.setDuration(500);
            slide.excludeTarget(android.R.id.statusBarBackground, true);
            slide.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(slide);

            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_a);
            getWindow().setExitTransition(transition);
        }
        setContentView(R.layout.activity_animal_selector);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void displayAlphabet(View view){
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AnimalSelectorActivity.this, null);
        Intent i = new Intent(AnimalSelectorActivity.this, AnimalActivity.class);
        switch(view.getId()){
            case R.id.btnBird:
                i.putExtra(ANIMAL_ID,1);
                break;
            case R.id.btnCat:
                i.putExtra(ANIMAL_ID,2);
                break;
            case R.id.btnDeer:
                i.putExtra(ANIMAL_ID,3);
                break;
            case R.id.btnDog:
                i.putExtra(ANIMAL_ID,4);
                break;
            case R.id.btnGiraffe:
                i.putExtra(ANIMAL_ID,5);
                break;
        }
        startActivity(i, options.toBundle());
    }
}

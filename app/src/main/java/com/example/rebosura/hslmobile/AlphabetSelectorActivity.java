package com.example.rebosura.hslmobile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

/**
 * Created by Rebosura on 3/3/2018.
 */

public class AlphabetSelectorActivity extends AppCompatActivity{

    public static final String TOPIC_NUMBER = "topic_number";
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
        setContentView(R.layout.activtiy_alphabet_selector);
    }
    //****************************************************************************************************************************//
    //this method determines which button was pressed to show the corresponding XML layout. The XML Layout "activity_alphabet.xml"//
    //now acts as an blueprint for all the alphabet activities.*******************************************************************//
    //****************************************************************************************************************************//
    public void displayAlphabet(View view){
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AlphabetSelectorActivity.this, null);
        Intent i = new Intent(AlphabetSelectorActivity.this, AlphabetActivity.class);
        switch(view.getId()){
            case R.id.btnA:
                i.putExtra(TOPIC_NUMBER, 1);
                break;
            case R.id.btnB:
                i.putExtra(TOPIC_NUMBER, 2);
                break;
            case R.id.btnC:
                i.putExtra(TOPIC_NUMBER, 3);
                break;
            case R.id.btnD:
                i.putExtra(TOPIC_NUMBER, 4);
                break;
            case R.id.btnE:
                i.putExtra(TOPIC_NUMBER, 5);
                break;
            case R.id.btnF:
                i.putExtra(TOPIC_NUMBER, 6);
                break;
            case R.id.btnG:
                i.putExtra(TOPIC_NUMBER, 7);
                break;
            case R.id.btnH:
                i.putExtra(TOPIC_NUMBER, 8);
                break;
            case R.id.btnI:
                i.putExtra(TOPIC_NUMBER, 9);
                break;
            case R.id.btnJ:
                i.putExtra(TOPIC_NUMBER, 10);
                break;
            case R.id.btnK:
                i.putExtra(TOPIC_NUMBER, 11);
                break;
            case R.id.btnL:
                i.putExtra(TOPIC_NUMBER, 12);
                break;
            case R.id.btnM:
                i.putExtra(TOPIC_NUMBER, 13);
                break;
            case R.id.btnN:
                i.putExtra(TOPIC_NUMBER, 14);
                break;
            case R.id.btnO:
                i.putExtra(TOPIC_NUMBER, 15);
                break;
            case R.id.btnP:
                i.putExtra(TOPIC_NUMBER, 16);
                break;
            case R.id.btnQ:
                i.putExtra(TOPIC_NUMBER, 17);
                break;
            case R.id.btnR:
                i.putExtra(TOPIC_NUMBER, 18);
                break;
            case R.id.btnT:
                i.putExtra(TOPIC_NUMBER, 19);
                break;
            case R.id.btnU:
                i.putExtra(TOPIC_NUMBER, 20);
                break;
            case R.id.btnV:
                i.putExtra(TOPIC_NUMBER, 21);
                break;
            case R.id.btnW:
                i.putExtra(TOPIC_NUMBER, 22);
                break;
            case R.id.btnX:
                i.putExtra(TOPIC_NUMBER, 23);
                break;
            case R.id.btnY:
                i.putExtra(TOPIC_NUMBER, 24);
                break;
            case R.id.btnZ:
                i.putExtra(TOPIC_NUMBER, 25);
                break;
        }
        startActivity(i, options.toBundle());
    }
}

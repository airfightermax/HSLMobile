package com.example.rebosura.hslmobile;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rebosura on 3/3/2018.
 */

public class AlphabetActivity extends AppCompatActivity {

    private InfoLibrary mInfoLibrary = new InfoLibrary();
    private TextView mLetter;
    private ImageView mImage;
    private Button btnLeft, btnRight;


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
        setContentView(R.layout.activity_alphabet);
        mLetter = (TextView)findViewById(R.id.tvAlphabet);
        mImage = (ImageView)findViewById(R.id.ivPicture);

        Intent i = getIntent();
        int topicNumber = i.getIntExtra(AlphabetSelectorActivity.TOPIC_NUMBER,0);
        mLetter.setText(mInfoLibrary.getLetters(topicNumber-1));
        mImage.setImageDrawable(getResources().getDrawable(mInfoLibrary.getAlphabetImages(topicNumber-1)));

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 0; x <= 23; x++){
                    String currentLetter = mLetter.getText().toString();
                    String letters = mInfoLibrary.getLetters(x);
                    if(currentLetter.equals(letters)){
                        updateLetter(x+1);
                        break;
                    }
                }
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 24; x >=1; x--){
                    if(mLetter.getText().toString().equals(mInfoLibrary.getLetters(x))){
                        updateLetter(x-1);
                        break;
                    }
                }
            }
        });
    };

    private void updateLetter(int a){
        mLetter.setText(mInfoLibrary.getLetters(a));
        mImage.setImageDrawable(getResources().getDrawable(mInfoLibrary.getAlphabetImages(a)));

    }
}

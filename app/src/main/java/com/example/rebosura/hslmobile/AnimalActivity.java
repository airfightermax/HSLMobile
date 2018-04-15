package com.example.rebosura.hslmobile;
import android.content.Intent;
import android.graphics.BitmapFactory;
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

import org.w3c.dom.Text;

/**
 * Created by Rebosura on 3/9/2018.
 */

public class AnimalActivity extends AppCompatActivity{
    InfoLibrary infoLibrary = new InfoLibrary();
    private int entryNumber = 0;
    private Button btnLeft, btnRight;
    private TextView tvAnimalLabel;
    private ImageView ivAnimal, ivAnimalSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            Slide slide = new Slide();
            slide.setDuration(500);
            slide.excludeTarget(android.R.id.statusBarBackground, true);
            slide.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(slide);
            getWindow().setExitTransition(slide);
        }
        setContentView(R.layout.activity_animals);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        tvAnimalLabel = (TextView)findViewById(R.id.tvAnimalLabel);
        ivAnimal = (ImageView)findViewById(R.id.ivAnimal);
        ivAnimalSign = (ImageView)findViewById(R.id.ivAnimalSign);

        Intent i = getIntent();
        int animal_id = i.getIntExtra(AnimalSelectorActivity.ANIMAL_ID, 0);
        updateEntry(animal_id);

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 0; x <= 6; x++){
                    String currentEntry = tvAnimalLabel.getText().toString();
                    String entry = infoLibrary.getAnimals(x);
                    if(currentEntry.equals(entry)){
                        updateEntry(x+1);
                        break;
                    }
                }
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 7; x >= 1; x--){
                    String currentEntry = tvAnimalLabel.getText().toString();
                    String entry = infoLibrary.getAnimals(x);
                    if(currentEntry.equals(entry)){
                        updateEntry(x-1);
                        break;
                    }
                }
            }
        });
    }

    private void updateEntry(int a){
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inSampleSize = 2;
        ivAnimal.setImageBitmap(BitmapFactory.decodeResource(getResources(), infoLibrary.getAnimalImages(a,0), bmOptions));
        ivAnimalSign.setImageBitmap(BitmapFactory.decodeResource(getResources(), infoLibrary.getAnimalImages(a,1), bmOptions));
        tvAnimalLabel.setText(infoLibrary.getAnimals(a));
        //ivAnimal.setImageDrawable(getResources().getDrawable(infoLibrary.getAnimalImages(a, 0)));
        //ivAnimalSign.setImageDrawable(getResources().getDrawable(infoLibrary.getAnimalImages(a, 1)));
    }
}

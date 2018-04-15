package com.example.rebosura.hslmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rebosura on 4/11/2018.
 */

public class DictionayActivity extends AppCompatActivity{

    InfoLibrary mInfoLibrary = new InfoLibrary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_description);
        Intent i = getIntent();
        int list_id = i.getIntExtra(DictionarySelectorActivity.LIST_ITEM, 0);

        TextView tvDictionaryName = (TextView) findViewById(R.id.tvDictionaryName);
        ImageView ivDictionaryImage = (ImageView) findViewById(R.id.ivDictionaryImage);
        TextView tvDictionaryDescription = (TextView) findViewById(R.id.tvDictionaryDescription);

        tvDictionaryName.setText(mInfoLibrary.getDictionary(list_id));
        ivDictionaryImage.setImageDrawable(getResources().getDrawable(mInfoLibrary.getDictionaryImages(list_id)));
    }
}

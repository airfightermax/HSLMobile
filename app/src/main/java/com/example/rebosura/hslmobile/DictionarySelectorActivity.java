package com.example.rebosura.hslmobile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Rebosura on 4/8/2018.
 */

public class DictionarySelectorActivity extends AppCompatActivity{

    public static final String LIST_ITEM = "list_item";
    InfoLibrary infoLibrary = new InfoLibrary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_list);


        ListView lvDictionary = (ListView)findViewById(R.id.lvDictionary);

        lvDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DictionarySelectorActivity.this, infoLibrary.getDictionary(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DictionarySelectorActivity.this, DictionayActivity.class);
                intent.putExtra(LIST_ITEM, i);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(DictionarySelectorActivity.this, null);
                startActivity(intent, options.toBundle());
            }
        });

        CustomAdapter customAdapter = new CustomAdapter();
        lvDictionary.setAdapter(customAdapter);


    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return infoLibrary.getDictionaryArray().length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.dictionary_items, null);
            TextView tvDictionaryitem = (TextView)view.findViewById(R.id.tvDictionaryItem);
            tvDictionaryitem.setText(infoLibrary.getDictionary(i));
            return view;
        }
    }
}

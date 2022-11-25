package com.nurulaliyah_f55121069.fashionme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WomanClothing extends AppCompatActivity {
    private String [] dataName;
    private String [] dataDescription;
    private TypedArray dataPhoto;
    private WomanHeroAdapter adapter;
    private ArrayList<WomanHero> womanheros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_clothing);

        adapter = new WomanHeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(WomanClothing.this, womanheros.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        womanheros = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            WomanHero womanHero = new WomanHero();
            womanHero.setPhoto(dataPhoto.getResourceId(i, -1));
            womanHero.setName(dataName[i]);
            womanHero.setDescription(dataDescription[i]);
            womanheros.add(womanHero);
        }
        adapter.setWoman(womanheros);

    }
}
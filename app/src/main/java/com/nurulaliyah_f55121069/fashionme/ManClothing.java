package com.nurulaliyah_f55121069.fashionme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ManClothing extends AppCompatActivity {
    private String[] manMerk;
    private String[] manHarga;
    private TypedArray manImg;
    private ManHeroAdapter adapter;
    private ArrayList<ManHero> manHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_clothing);

        adapter = new ManHeroAdapter(this);
        ListView listView = findViewById(R.id.list_man);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ManClothing.this, manHeroes.get(i).getMerk(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void prepare() {
        manMerk = getResources().getStringArray(R.array.man_merk);
        manHarga = getResources().getStringArray(R.array.man_harga);
        manImg = getResources().obtainTypedArray(R.array.man_img);
    }

    private void addItem() {
        manHeroes = new ArrayList<>();

        for (int i = 0; i < manMerk.length; i++) {
            ManHero manHero = new ManHero();
            manHero.setPhoto(manImg.getResourceId(i, -1));
            manHero.setMerk(manMerk[i]);
            manHero.setHarga(manHarga[i]);
            manHeroes.add(manHero);
        }
        adapter.setManheroes(manHeroes);
    }
}
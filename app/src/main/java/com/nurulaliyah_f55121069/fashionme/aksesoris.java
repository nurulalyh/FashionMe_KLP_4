package com.nurulaliyah_f55121069.fashionme;

import static android.os.Looper.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class aksesoris extends AppCompatActivity {
    private String[] manMerk;
    private String[] manHarga;
    private TypedArray manImg;
    private AksesorisAdapter adapter;
    private ArrayList<AksesorisHero> aksesorisHeroes;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_aksesoris);

        adapter = new AksesorisAdapter(this);
        ListView listView = findViewById(R.id.list_aksesoris);
        listView.setAdapter(adapter);

        prepare();
        addItem();

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              Toast.makeText(aksesoris.this, aksesorisHeroes.get(i).getMerk(), Toast.LENGTH_SHORT).show();
          }
        });
    }
    private void prepare() {
        manMerk = getResources().getStringArray(R.array.man_merk);
        manHarga = getResources().getStringArray(R.array.man_harga);
       manImg = getResources().obtainTypedArray(R.array.man_img);
    }

   private void addItem() {
       aksesorisHeroes = new ArrayList<>();
       for (int i = 0; i < manMerk.length; i++) {
           AksesorisHero aksesorisHero = new AksesorisHero();
           aksesorisHero.setPhoto(manImg.getResourceId(i, -1));
           aksesorisHero.setMerk(manMerk[i]);
           aksesorisHero.setHarga(manHarga[i]);
           aksesorisHeroes.add(aksesorisHero);
        }
        adapter.setAksesorisHeroes(aksesorisHeroes);
    }
}
package com.nurulaliyah_f55121069.fashionme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManHeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ManHero> manheroes;

    public void setManheroes(ArrayList<ManHero> manheroes) {
        this.manheroes = manheroes;
    }

    public ManHeroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return manheroes.size();
    }

    @Override
    public Object getItem(int i) {
        return manheroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_man, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        ManHero manHero = (ManHero) getItem(i);
        viewHolder.bind(manHero);
        return view;
    }

    private class ViewHolder {
        private TextView txtMerk;
        private TextView txtHarga;
        private ImageView imgMan;

        ViewHolder(View view) {
            txtMerk = view.findViewById(R.id.txt_merk);
            txtHarga = view.findViewById(R.id.txt_harga);
            imgMan = view.findViewById(R.id.img_photo);
        }

        void bind(ManHero manHero) {
            txtMerk.setText(manHero.getMerk());
            txtHarga.setText(manHero.getHarga());
            imgMan.setImageResource(manHero.getPhoto());
        }
    }
}

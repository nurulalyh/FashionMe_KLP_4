package com.nurulaliyah_f55121069.fashionme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AksesorisAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AksesorisHero> aksesorisHeroes;

    public AksesorisAdapter(Context context) {
        this.context = context;
  }

    public void setAksesorisHeroes(ArrayList<AksesorisHero> aksesorisHeroes) {
       this.aksesorisHeroes = aksesorisHeroes;
    }

    @Override
   public int getCount() {
       return aksesorisHeroes.size();}

   @Override
   public Object getItem(int i) {
     return aksesorisHeroes.get(i);
    }

   @Override
    public long getItemId(int i) {
        return i;
    }

   @Override
   public View getView(int i, View view, ViewGroup viewGroup) {
       if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_aksesoris, viewGroup, false);
        }

       ViewHolder viewHolder = new ViewHolder(view);
       AksesorisHero aksesorisHero = (AksesorisHero) getItem(i);
       viewHolder.bind(aksesorisHero);
       return view;
    }

    private class ViewHolder {
        private TextView txtMerk;
        private TextView txtHarga;
        private ImageView imgAksesoris;

        ViewHolder(View view) {
            txtMerk = view.findViewById(R.id.txt_merk);
            txtHarga = view.findViewById(R.id.txt_harga);
            imgAksesoris = view.findViewById(R.id.img_photo);
        }

        void bind(AksesorisHero manHero) {
            txtMerk.setText(manHero.getMerk());
           txtHarga.setText(manHero.getHarga());
            imgAksesoris.setImageResource(manHero.getPhoto());
           }
   }
}

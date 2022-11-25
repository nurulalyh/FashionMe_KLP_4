package com.nurulaliyah_f55121069.fashionme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WomanHeroAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<WomanHero> Woman;

    public void setWoman(ArrayList<WomanHero> Woman) {
        this.Woman = Woman;
    }

    public WomanHeroAdapter(Context context) {
        this.context = context;
        Woman = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return Woman.size();
    }

    @Override
    public Object getItem(int i) {
        return Woman.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_woman, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        WomanHero womanhero = (WomanHero) getItem(i);
        viewHolder.bind(womanhero);
        return view;
    }

    private class ViewHolder {
        private final TextView txtName;
        private final TextView txtDescription;
        private final ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(WomanHero Womenhero) {
            txtName.setText(Womenhero.getName());
            txtDescription.setText(Womenhero.getDescription());
            imgPhoto.setImageResource(Womenhero.getPhoto());
        }
    }
}

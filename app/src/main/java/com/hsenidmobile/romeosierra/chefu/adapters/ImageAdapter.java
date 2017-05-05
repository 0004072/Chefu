package com.hsenidmobile.romeosierra.chefu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.chefu.R;
import com.hsenidmobile.romeosierra.chefu.model.FoodItem;

import java.util.ArrayList;

/**
 * Created by kanchana on 5/3/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoodItem> foodItems; // TODO: 5/3/17 replace with the result of data fetching from API

    public ImageAdapter(Context context, ArrayList<FoodItem> foodItems){
        this.context = context;
        this.foodItems = foodItems;
        System.out.println();
    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int i) {
        return foodItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (view == null) {
            gridView = new View(context);
            gridView = layoutInflater.inflate(R.layout.grid_view_item, null);
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(foodItems.get(i).getName());
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);
            imageView.setImageResource(R.drawable.pizza);// TODO: 5/5/17 Change this to fetch data from the server

        } else {
            gridView = view;
        }

        return gridView;
    }
}

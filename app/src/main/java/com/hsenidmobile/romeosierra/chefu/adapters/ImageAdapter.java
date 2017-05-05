package com.hsenidmobile.romeosierra.chefu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.chefu.R;

/**
 * Created by kanchana on 5/3/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private String[] foodItems; // TODO: 5/3/17 replace with the result of data fetching from API

    public ImageAdapter(Context context, String[] foodItems){
        this.context = context;
        this.foodItems = foodItems;
        System.out.println();
    }

    @Override
    public int getCount() {
        return foodItems.length;
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
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (view == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = layoutInflater.inflate(R.layout.grid_view_item, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(foodItems[i]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String mobile = foodItems[i];

            imageView.setImageResource(R.drawable.pizza);

        } else {
            gridView = view;
        }

        return gridView;
    }
}

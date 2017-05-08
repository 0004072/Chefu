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
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by kanchana on 5/3/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoodItem> foodItems;
    private DisplayImageOptions options;

    public ImageAdapter(Context context, ArrayList<FoodItem> foodItems){
        this.context = context;
        this.foodItems = foodItems;
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.pizza)
                .showImageOnFail(R.drawable.pizza)
                .showImageOnLoading(R.drawable.pizza).build();
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

        View foodItemView;

        if (view == null) {
            foodItemView = new View(context);
            foodItemView = layoutInflater.inflate(R.layout.grid_view_item, null);
            TextView itemName = (TextView) foodItemView
                    .findViewById(R.id.item_name);
            itemName.setText(foodItems.get(i).getName());

            TextView itemDescription = (TextView)foodItemView.findViewById(R.id.item_desc);
            itemDescription.setText(foodItems.get(i).getDescription());

            ImageView imageView = (ImageView) foodItemView.findViewById(R.id.item_thumbnail);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(foodItems.get(i).getImage(), imageView, options);

        } else {
            foodItemView = view;
        }

        return foodItemView;
    }
}

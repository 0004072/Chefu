package com.hsenidmobile.romeosierra.chefu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.chefu.R;
import com.hsenidmobile.romeosierra.chefu.config.ImageLoaderConfig;
import com.hsenidmobile.romeosierra.chefu.model.FoodItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by kanchana on 5/3/17.
 */

public class FoodItemCardAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoodItem> foodItems;
    private DisplayImageOptions options;

    public FoodItemCardAdapter(Context context, ArrayList<FoodItem> foodItems){
        this.context = context;
        this.foodItems = foodItems;
        options = ImageLoaderConfig.getOptions();
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

        if (view == null) {
            //view = new View(context);
            view = layoutInflater.inflate(R.layout.grid_view_item, null);
            TextView txt_itemName = (TextView) view
                    .findViewById(R.id.txt_item_name);
            txt_itemName.setText(foodItems.get(i).getName());

            TextView txt_ItemDesc = (TextView)view.findViewById(R.id.item_desc);
            txt_ItemDesc.setText(foodItems.get(i).getDescription());

            ImageView img_ItemThumbnail = (ImageView) view.findViewById(R.id.img_item_thumbnail);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(foodItems.get(i).getImage(), img_ItemThumbnail, options);
        }
        return view;
    }
}

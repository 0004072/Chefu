package com.hsenidmobile.romeosierra.chefu.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.hsenidmobile.romeosierra.chefu.model.FoodItem;

/**
 * Created by kanchana on 5/5/17.
 */

public class FoodItemView extends CardView {
    private FoodItem foodItem;

    public FoodItemView(Context context) {
        super(context);
    }

    public FoodItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FoodItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FoodItemView setFoodItem(FoodItem foodItem){
        this.foodItem = foodItem;
        return this;
    }

    public FoodItem getFoodItem(){
        return this.foodItem;
    }
}

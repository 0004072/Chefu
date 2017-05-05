package com.hsenidmobile.romeosierra.chefu.model;

import java.util.ArrayList;

/**
 * Created by kanchana on 4/28/17.
 */

public class Food {
    private ArrayList<FoodItem> food;

    public ArrayList<FoodItem> getFood() {
        return food;
    }

    public void setFood(ArrayList<FoodItem> food) {
        this.food = food;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(FoodItem f : food){
            sb.append(f.getName()).append('\n');
            sb.append(f.getDescription()).append('\n');
            sb.append(f.getPrice()).append('\n');
            sb.append(f.getImage()).append('\n');
            Extra extra = f.getExtra();

            if(extra != null) {
                Topping[] toppings = extra.getToppings();
                if(toppings != null) {
                    sb.append("Toppings:\n\t");
                    for (Topping t : toppings) {
                        sb.append(t.getName()).append("\n\t");
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Food() {

    }

    public Food(ArrayList<FoodItem> food) {
        this.food = food;
    }
}

package com.hsenidmobile.romeosierra.chefu.model;

/**
 * Created by kanchana on 4/28/17.
 */

public class FoodItem {
    private String name, price, description, image;
    private Extra extra;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extras) {
        this.extra = extras;
    }

    public FoodItem(String name, String price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}

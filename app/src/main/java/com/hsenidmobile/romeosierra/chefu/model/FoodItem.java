package com.hsenidmobile.romeosierra.chefu.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kanchana on 4/28/17.
 */

public class FoodItem implements Parcelable {
    private String name, price, description, image;
    private Extra extra;
    private int mData;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.price);
        dest.writeString(this.description);
        dest.writeString(this.image);
        dest.writeParcelable(this.extra, flags);
        dest.writeInt(this.mData);
    }

    protected FoodItem(Parcel in) {
        this.name = in.readString();
        this.price = in.readString();
        this.description = in.readString();
        this.image = in.readString();
        this.extra = in.readParcelable(Extra.class.getClassLoader());
        this.mData = in.readInt();
    }

    public static final Parcelable.Creator<FoodItem> CREATOR = new Parcelable.Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel source) {
            return new FoodItem(source);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };
}

package com.hsenidmobile.romeosierra.chefu.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kanchana on 5/2/17.
 */

public class Topping implements Parcelable {
    private String name;
    private String image;
    private String price;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.price);
    }

    public Topping() {
    }

    protected Topping(Parcel in) {
        this.name = in.readString();
        this.image = in.readString();
        this.price = in.readString();
    }

    public static final Parcelable.Creator<Topping> CREATOR = new Parcelable.Creator<Topping>() {
        @Override
        public Topping createFromParcel(Parcel source) {
            return new Topping(source);
        }

        @Override
        public Topping[] newArray(int size) {
            return new Topping[size];
        }
    };
}

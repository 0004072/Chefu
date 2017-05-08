package com.hsenidmobile.romeosierra.chefu.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kanchana on 5/2/17.
 */

public class Extra implements Parcelable {
    private Topping[] toppings;

    public Topping[] getToppings() {
        return toppings;
    }

    public void setToppings(Topping[] toppings) {
        this.toppings = toppings;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.toppings, 0);
    }

    public Extra() {
    }

    protected Extra(Parcel in) {
        this.toppings = in.createTypedArray(Topping.CREATOR);
    }

    public static final Parcelable.Creator<Extra> CREATOR = new Parcelable.Creator<Extra>() {
        @Override
        public Extra createFromParcel(Parcel source) {
            return new Extra(source);
        }

        @Override
        public Extra[] newArray(int size) {
            return new Extra[size];
        }
    };
}

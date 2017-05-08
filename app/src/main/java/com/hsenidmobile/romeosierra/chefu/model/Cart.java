package com.hsenidmobile.romeosierra.chefu.model;

import java.util.Map;

/**
 * Created by kanchana on 5/8/17.
 */

public class Cart {
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void incrementTotal(double value){
        this.total += value;
    }

    public void decrementTotal(double value){
        this.total -= value;
    }
}

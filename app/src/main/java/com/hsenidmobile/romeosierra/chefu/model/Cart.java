package com.hsenidmobile.romeosierra.chefu.model;

/**
 * Created by kanchana on 5/8/17.
 */

public class Cart {
    // TODO: 5/9/17 Incorporate the complete shopping cart functionality. This is just a mock, only for the purpose of tracking the total.
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

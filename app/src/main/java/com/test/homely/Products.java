package com.test.homely;

public class Products {
    private String Name, Qty;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public Products(String namee, String qty) {
        Name = namee;
        Qty = qty;
    }

    public Products() {

    }

}

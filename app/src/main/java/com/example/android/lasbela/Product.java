package com.example.android.lasbela;

public class Product {
    private String mProductName;
    private double mProductPrice;
    private int mImageResourceId;
    public Product(String ProductName,double ProductPrice,int ImageResourceId) {
        mProductName=ProductName;
        mProductPrice=ProductPrice;
        mImageResourceId=ImageResourceId;
    }
    public String getProductName() {
        return mProductName;
    }
    public double getProductPrice() {
        return mProductPrice;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }
}

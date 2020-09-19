package com.example.android.lasbela;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Activity context, ArrayList<Product> products) {

        super(context,0,products);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Product currentProduct=getItem(position);
        TextView nameTextView=(TextView)listItemView.findViewById(R.id.productName);
        nameTextView.setText(currentProduct.getProductName());
        TextView priceTextView=(TextView)listItemView.findViewById(R.id.productPrice);
        priceTextView.setText(currentProduct.getProductPrice()+"");
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentProduct.getImageResourceId());
        return listItemView;
    }
}

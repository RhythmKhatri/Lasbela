package com.example.android.lasbela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Product> products=new ArrayList<Product>();
        products.add(new Product("Pants",2200.0,R.drawable.family_father));
        products.add(new Product("Pants",2200.0,R.drawable.family_mother));
        products.add(new Product("Pants",2200.0,R.drawable.family_younger_brother));
        products.add(new Product("Pants",2200.0,R.drawable.family_younger_sister));
        products.add(new Product("Pants",2200.0,R.drawable.family_older_brother));
        products.add(new Product("Pants",2200.0,R.drawable.family_older_sister));
        products.add(new Product("Pants",2200.0,R.drawable.family_daughter));
        products.add(new Product("Pants",2200.0,R.drawable.family_son));
        products.add(new Product("Pants",2200.0,R.drawable.family_grandfather));
        products.add(new Product("Pants",2200.0,R.drawable.family_grandmother));
        ProductAdapter adapter=new ProductAdapter(this,products);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product=products.get(i);
            Intent intent=new Intent(MainActivity.this,DescriptionActivity.class);
            intent.putExtra("image",product.getImageResourceId());
            intent.putExtra("name",product.getProductName());
            intent.putExtra("price",product.getProductPrice());
            startActivity(intent);
            }
        });
    }
}
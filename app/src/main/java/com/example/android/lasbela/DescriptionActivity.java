package com.example.android.lasbela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {
    Button btnIncrement,btnDecrement;
    TextView tvQuantity,tvCart,tvCheckOut,descriptionProductName,descriptionProductPrice;
    RadioGroup radioGroup;
    RadioButton sizeRadioButton;
    ImageView descriptionImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        btnIncrement=(Button)findViewById(R.id.btnIncrement);
        btnDecrement=(Button)findViewById(R.id.btnDecrement);
        tvQuantity=(TextView)findViewById(R.id.tvQuantity);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        tvCart=(TextView)findViewById(R.id.tvCart);
        tvCheckOut=(TextView)findViewById(R.id.tvCheckOut);
        descriptionImageView=(ImageView)findViewById(R.id.descriptionImage);
        descriptionProductName=(TextView)findViewById(R.id.descriptionProductName);
        descriptionProductPrice=(TextView)findViewById(R.id.descriptionProductPrice);
        Intent intent=getIntent();
        int descriptionImageId=intent.getIntExtra("image",0);
        descriptionImageView.setImageResource(descriptionImageId);
        String descriptionName=intent.getStringExtra("name");
        descriptionProductName.setText(descriptionName);
        String descriptionPrice=intent.getStringExtra("price");
        descriptionProductPrice.setText(descriptionPrice);
        if(tvQuantity.getText().toString()=="1") {
            btnDecrement.setEnabled(false);
        }
        tvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                sizeRadioButton=(RadioButton)findViewById(selectedId);
                if(selectedId==-1)
                    Toast.makeText(view.getContext(),"Select a suitable Size",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(view.getContext(),tvQuantity.getText()+" "+sizeRadioButton.getText()+"Size added to Cart",Toast.LENGTH_SHORT).show();
            }
        });
        tvCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                sizeRadioButton=(RadioButton)findViewById(selectedId);
                if(selectedId==-1)
                    Toast.makeText(view.getContext(),"Select a suitable Size",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(view.getContext(),tvQuantity.getText()+" "+sizeRadioButton.getText()+"Size Order Placed",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void increment(View view) {
        int quant=Integer.parseInt(tvQuantity.getText().toString());
        quant++;
        tvQuantity.setText(quant+"");
        btnDecrement.setEnabled(true);
    }
    public void decrement(View view) {
        int quant=Integer.parseInt(tvQuantity.getText().toString());
        quant--;
        tvQuantity.setText(quant+"");
        if(quant==1)
            btnDecrement.setEnabled(false);
    }

}
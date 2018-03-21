package com.example.rajatkrishnan.mytask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Order extends AppCompatActivity {
    int total, cart, total1, cart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle bundle = getIntent().getExtras();
        total = bundle.getInt("Total");
        cart = bundle.getInt("Cart Value");
        displaycart(cart);
        displaytotal(total);


    }

    private void displaycart(int cart) {
        TextView scoreView = (TextView) findViewById(R.id.t3);
        scoreView.setText(String.valueOf(cart));
    }

    private void displaytotal(int total) {
        TextView scoreView = (TextView) findViewById(R.id.t4);
        scoreView.setText(String.valueOf(total));
    }
    public void button(View v){
        Intent i= new Intent(Order.this,MainActivity.class);
        startActivity(i);

    }

}

package com.example.rajatkrishnan.mytask;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.value;

public class SecondActivity extends AppCompatActivity {

    int total, cart, total1, cart1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
            total = bundle.getInt("Total");
            cart = bundle.getInt("Cart Value");
        displaycart(cart);
        displaytotal(total);
        total1 = total;
        cart1 = cart;
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

     public void b1(View v){
        total=total+20;
        cart=cart+1;
        displaytotal(total);
        displaycart(cart);

    }

    private void displaycart(int cart) {
        TextView scoreView = (TextView) findViewById(R.id.t3);
        scoreView.setText(String.valueOf(cart));
    }

    private void displaytotal(int total) {
        TextView scoreView = (TextView) findViewById(R.id.t4);
        scoreView.setText(String.valueOf(total));
    }

        public void b2(View v) {
            if (cart > cart1 && total > total1) {
                cart = cart - 1;
                total = total - 20;
            }
            displaycart(cart);
            displaytotal(total);
        }

    public void button(View v) {
            Intent intent = new Intent(SecondActivity.this, Main3Activity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Cart Value", cart);
            bundle.putInt("Total", total);
            intent.putExtras(bundle);
            startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}

package com.example.rajatkrishnan.mytask;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
int total=0;
    int cart=0;
    int flag = 0, counter = 0, counter1 = 0;
int oldVaue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void b1(View v){
        total=total+10;
        cart=cart+1;
        displaytotal(total);
        displaycart(cart);

    }

    private void displaycart(int cart) {
        TextView scoreView = (TextView) findViewById(R.id.t1);
        scoreView.setText(String.valueOf(cart));
    }

    private void displaytotal(int total) {
        TextView scoreView = (TextView) findViewById(R.id.t2);
        scoreView.setText(String.valueOf(total));
    }

    public void b2(View v) {
        if (cart > 0 && total > 0) {
            cart = cart - 1;
            total = total - 10;
        }
        displaytotal(total);
        displaycart(cart);
    }

    public void button(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Cart Value", cart);
            bundle.putInt("Total", total);
            intent.putExtras(bundle);
            startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("You Can only go back once your order is completed fully or you can exit the app");
        builder.setCancelable(true);
        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Exit App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();


    }


}

package com.example.safe_haven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class contacts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);



        Button Btncall = findViewById(R.id.Btncall);
        Btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09102124627"));
                startActivity(intent);
            }
        });
        Button Btncall1 = findViewById(R.id.Btncall1);
        Btncall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09369260710"));
                startActivity(intent);
            }
        });
        Button Btncall2 = findViewById(R.id.Btncall2);
        Btncall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09459976724"));
                startActivity(intent);
            }
        });
        Button Btncall3 = findViewById(R.id.Btncall3);
        Btncall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09272376878"));
                startActivity(intent);
            }
        });
    }
}
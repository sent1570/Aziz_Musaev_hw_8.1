package com.example.aziz_musaev_hw_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.policy2);
        textView2 = findViewById(R.id.product_category2);
        String newValue1 = getIntent().getStringExtra("Miku2");
        String newValue2 = getIntent().getStringExtra("Miku");
        textView.setText(newValue1);
        textView2.setText(newValue2);

    }
}
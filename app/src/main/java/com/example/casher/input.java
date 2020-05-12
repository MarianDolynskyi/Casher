package com.example.casher;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class input extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);
    }
    public void getText()
    {
        String category = findViewById(R.id.categoryInput22);
    }
    public void Go(View view) {
        String category = findViewById(R.id.categoryInput22);
        int price = findViewById(R.id.SumInput);
        ClipData.Item item = new ClipData.Item(category.toString(),Integer.valueOf(price))
        Intent intent = new Intent(this, sample2.class);
        startActivity(intent);
    }
}

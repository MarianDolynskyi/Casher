package com.example.casher;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class sample extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList();
    private FirebaseDatabase database;
    DatabaseReference myRef;
    ListView productList;

    private EditText CategoryInput;
//    private EditText SumInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        productList = (ListView) findViewById(R.id.productList);
//        ProductAdapter adapter = new ProductAdapter(this, R.layout.list_item, products);
//        productList.setAdapter(adapter);

//        final EditText SumInput = (EditText) findViewById(R.id.SumInput);
    }
    public void startActivity(View v) {
//        DialogFragment Dialog = new CustomDialogFragment();
//        Dialog.show(getSupportFragmentManager(), "dialog");
                Intent intent = new Intent(this, input.class);
        startActivity(intent);
    }
}

package com.example.casher;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class sample extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList();
    ListView productList;
    final Context context = this;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    private EditText CategoryInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        productList = (ListView) findViewById(R.id.productList);

    }
    public void startActivity(View v) {
        //create view for dialog
        LayoutInflater li = LayoutInflater.from(context);
        View dialogView = li.inflate(R.layout.dialog, null);

        //create AlertDialog
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

        //setting up dialog.xml for AlertDialog
        mDialogBuilder.setView(dialogView);

        final EditText sumInput = (EditText) dialogView.findViewById(R.id.SumInput);

        //Setting up a Dialog Frame
        mDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                myRef = FirebaseDatabase.getInstance().getReference();
                                myRef.child(user.getUid()).child("Costs").push().setValue(sumInput.getText().toString());

                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        //Create AlertDialog:
        AlertDialog alertDialog = mDialogBuilder.create();
        alertDialog.show();

    }
}

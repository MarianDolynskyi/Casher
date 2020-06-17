package com.example.casher;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class input extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private EditText SumInput2;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);
    }

    public void Go(View view) {
        SumInput2 = (EditText)findViewById(R.id.SumInput2);
        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child(user.getUid()).child("Costs").push().setValue(SumInput2.getText().toString());
//        Intent intent = new Intent(this, CustomDialogFragment.class);
//        startActivity(intent);
    }
}

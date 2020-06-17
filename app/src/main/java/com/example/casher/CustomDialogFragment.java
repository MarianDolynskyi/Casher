package com.example.casher;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CustomDialogFragment extends DialogFragment {
private EditText CategoryInput;
private EditText SumInput;

private FirebaseAuth mAuth;
private DatabaseReference myRef;

FirebaseUser user = mAuth.getInstance().getCurrentUser();


    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        myRef = FirebaseDatabase.getInstance().getReference();
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Витрати")
                .setView(R.layout.dialog)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        SumInput.getText();
                        myRef.child(user.getUid()).child("Costs").push().setValue(SumInput.getText().toString());
                    }
                })
//                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();

    }


}
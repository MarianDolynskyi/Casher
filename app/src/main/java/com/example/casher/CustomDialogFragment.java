package com.example.casher;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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
//final CustomDialogFragment context = this;

//    private FirebaseAuth mAuth;
//    private DatabaseReference myRef;
//    private EditText SumInput2;

//    FirebaseUser user = mAuth.getInstance().getCurrentUser();


    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        LayoutInflater inflater = this.getLayoutInflater();
//        View view = inflater.inflate(R.layout.dialog, null);
//        final FirebaseAuth mAuth;
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//        LayoutInflater li = CustomDialogFragment.from(context);
//        View promptsView = li.inflate(R.layout.prompt, null);
        return builder
                .setTitle("Витрати")
                .setView(R.layout.dialog)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        final FirebaseAuth mAuth = null;
                        final DatabaseReference myRef;
                        final EditText SumInput2;

                        FirebaseUser user = mAuth.getInstance().getCurrentUser();
                        SumInput2 = (EditText) getView().findViewById(R.id.SumInput2);
                        myRef = FirebaseDatabase.getInstance().getReference();
                        myRef.child(user.getUid()).child("Costs").push().setValue(SumInput2.getText().toString());
                    }
                })
//                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();

    }


}
package com.example.casher;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class CustomDialogFragment extends DialogFragment {
String CategoryInput;
String SumInput;
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.sample ,null));
//       CategoryInput =  inflater.toString(R.id.categoryInput);
//       SumInput = inflater.toString(R.id.SumInput);
//        String test = editText.getText().toString();
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Витрати")
                .setView(R.layout.dialog)
                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();
    }


}
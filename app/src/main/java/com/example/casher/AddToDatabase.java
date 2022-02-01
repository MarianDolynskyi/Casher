package com.example.casher;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.casher.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by User on 2/16/2017.
 */

public class AddToDatabase extends AppCompatActivity {

    private static final String TAG = "AddToDatabase";

    private Button btnSubmitCosts;
    private Button btnSubmitIncome;
    private EditText mCategoryInputCosts;
    private EditText mSumInputCosts;
    private String userID;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);
        btnSubmitCosts = (Button) findViewById(R.id.btnSubmitCosts);
        btnSubmitIncome = (Button) findViewById(R.id.btnSubmitIncome);
        mCategoryInputCosts = (EditText) findViewById(R.id.categoryCostsInput);
        mSumInputCosts = (EditText) findViewById(R.id.sumCostsInput);


        //declare the database reference object. This is what we use to access the database.
        //NOTE: Unless you are signed in, this will not be useable.
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                    toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
//                    toastMessage("Successfully signed out.");
                }
                // ...
            }
        };


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "onDataChange: Added information to database: \n" +
                        dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        btnSubmitIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submit pressed.");
                String category = mCategoryInputCosts.getText().toString();
                String cash = mSumInputCosts.getText().toString();

                Log.d(TAG, "onClick: Attempting to submit to database: \n" +
                        "name: " + category + "\n" +
                        "email: " + cash + "\n"
                );

                //handle the exception if the EditText fields are null
                if(!category.equals("") && !cash.equals("")){
                    UserInformation userInformation = new UserInformation(category, cash);
                    myRef.child(userID).child("Income").push().setValue(userInformation);
                    toastMessage("New Information has been saved.");
//                    mName.setText("");
//                    mEmail.setText("");
//                    mPhoneNum.setText("");
                }else{
                    toastMessage("Fill out all the fields");
                }
            }
        });

        btnSubmitCosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submit pressed.");
                String category = mCategoryInputCosts.getText().toString();
                String cash = mSumInputCosts.getText().toString();

                Log.d(TAG, "onClick: Attempting to submit to database: \n" +
                        "name: " + category + "\n" +
                        "email: " + cash + "\n"
                );

                //handle the exception if the EditText fields are null
                if(!category.equals("") && !cash.equals("")){
                    UserInformation userInformation = new UserInformation(category, cash);
                    myRef.child(userID).child("Costs").push().setValue(userInformation);
                    toastMessage("New Information has been saved.");
//                    mName.setText("");
//                    mEmail.setText("");
//                    mPhoneNum.setText("");
                }else{
                    toastMessage("Fill out all the fields");
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void startActivitySample(View v) {
        Intent intent = new Intent(AddToDatabase.this, sample.class);
//        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton4);
//        imageButton.setVisibility(View.INVISIBLE);

//        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton5);
//        imageButton.setVisibility(View.VISIBLE);

        startActivity(intent);
    }
}

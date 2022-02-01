package com.example.casher;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.chart.common.dataentry.DataEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class sample extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList();
    ListView userList;
    final Context context = this;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    private EditText CategoryInput;
    public String categoryIncome;
    public String valueIncome;
    RecyclerView recyclerView;
    DatabaseReference databaseview;
    DatabaseReference databaseviewCosts;
    MyAdapter myAdapter;
    ArrayList<User> list;

    public sample(){
        // Default constructor required for calls to DataSnapshot.getValue(sample.class)
    }

    public sample(String categoryIncome, String valueIncome) {
        this.categoryIncome = categoryIncome;
        this.valueIncome = valueIncome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(user.getUid());
        recyclerView = findViewById(R.id.userList);
        databaseview = FirebaseDatabase.getInstance().getReference(user.getUid()).child("Income");
        databaseviewCosts = FirebaseDatabase.getInstance().getReference(user.getUid()).child("Costs");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
        databaseview.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    HashMap<String, String> messageMap = (HashMap<String, String>) dataSnapshot.getValue();

                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);


                    System.out.println(dataSnapshot.getKey());


                }
                myAdapter.notifyDataSetChanged();
//                CardView item = (CardView) findViewById(R.id.item);
//                System.out.println( item.getCardBackgroundColor());

            }


            //            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseviewCosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    HashMap<String, String> messageMap = (HashMap<String, String>) dataSnapshot.getValue();

                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                    System.out.println(dataSnapshot.getKey());


                }
                myAdapter.notifyDataSetChanged();

            }

            //            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        arr = new ArrayList<>();

//        if(products.size()==0){
//            products.add(new Product("Продукти", "-500грн"));
//            products.add(new Product("Заправка", "-300грн"));
//            products.add(new Product("Комунальні", "-1200грн"));
//            products.add(new Product("Ресторан", "-500грн"));
//            products.add(new Product("Кіно", "-300грн"));
//        }
//        userList = findViewById(R.id.userList);
//        ProductAdapter adapter = new ProductAdapter(this, R.layout.list_item, products);
//        productList.setAdapter(adapter);
    }
//        productList = findViewById(R.id.productList);

//    }

    public void startActivityAdd(View v) {
        Intent intent = new Intent(sample.this, AddToDatabase.class);
        startActivity(intent);
    }

    public void startActivityCharts(View v) {
        Intent intent = new Intent(sample.this, ActivityCharts.class);
        startActivity(intent);
    }

    public void startActivitySign(View v){
        Intent intent = new Intent(sample.this, MainActivity.class);
        startActivity(intent);
    }
}

package com.example.casher;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityCharts extends AppCompatActivity {
    String category, value;

    public String getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }
//    private sample sample;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    DatabaseReference databaseview;
    ArrayList<User> list;
    private User userList;
//    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        list = new ArrayList<User>();

        databaseview = FirebaseDatabase.getInstance().getReference(user.getUid()).child("Income");

        Pie pie = AnyChart.pie();

        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(ActivityCharts.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });

//        sample = new sample();
         final ArrayList<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Пальне", 1200));
        data.add(new ValueDataEntry("Продукти", 800));
        data.add(new ValueDataEntry("Кафе", 750));
        data.add(new ValueDataEntry("Кіно", 350));
        data.add(new ValueDataEntry("Комунальні", 1320));
        data.add(new ValueDataEntry("Подорож в гори", 1800));
        data.add(new ValueDataEntry("Курси програмування", 3800));


//        databaseview.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
////                    HashMap<String, String> messageMap = (HashMap<String, String>) dataSnapshot.getValue();
//
//                    User datads = dataSnapshot.getValue(User.class);
//                    list.add(datads);
//                    data.add(new ValueDataEntry(list.indexOf(category), list.indexOf(value)));
////                    System.out.println(list);
//
//
//                }
//
//            }
//
//            //            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        userList = new User();
//        dataArr = userList.getList();

        pie.data(data);

        pie.title("Ваші витрати:");

        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        anyChartView.setChart(pie);
    }
}

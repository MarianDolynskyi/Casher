package com.example.casher;

import com.anychart.chart.common.dataentry.DataEntry;

import java.util.ArrayList;

public class User {

    String category, value;
    private ArrayList<String> list;

    public User(){
        list = new ArrayList<String>();
        list.add(category);
        list.add(value);
    }
//    public ArrayList<DataEntry> getList() {
//        return list;
//    }

    public String getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }

}
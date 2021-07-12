package com.android.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetButton = findViewById(R.id.reset);
        final ListView newList = (ListView) findViewById(R.id.listView1);

        final ArrayList<String> family = returnFamilyList();

        final ArrayAdapter<String>[] familyA = new ArrayAdapter[]{new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, returnFamilyList())};
        newList.setAdapter(familyA[0]);
        resetButton.setOnClickListener(v -> {
            final ArrayAdapter<String> familyB = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, family);
            newList.setAdapter(familyB);
            familyA[0] = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, returnFamilyList());
        });
        newList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.i("NAME:", familyA[0].getItem(i));
            familyA[0].remove(familyA[0].getItem(i));
            newList.setAdapter(familyA[0]);
        });

    }

    /*TODO :
    *  Add more family members with their Full names
     */

    private ArrayList<String> returnFamilyList(){
        ArrayList<String> family = new ArrayList<>();
        family.add("AKIRA");
        family.add("TULTULI");
        family.add("CHANDAN");
        family.add("GOPAL");
        family.add("PUSPANJALI");
        family.add("SANTOSH");
        family.add("LINA");
        return family;
    }
}
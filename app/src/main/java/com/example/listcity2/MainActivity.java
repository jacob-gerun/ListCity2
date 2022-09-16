package com.example.listcity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] cities = {"Edmonton", "Calgary", "Moscow", "Berlin", "Toronto"};
    ArrayList<String> cityList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Button addCityButton;
    Button deleteCityButton;
    Button submitButton;
    EditText addCityText;
    LinearLayout addCityLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.cityListViewId);

        cityList = new ArrayList<>();
        cityList.addAll(Arrays.asList(cities));

        arrayAdapter = new ArrayAdapter<>(this, R.layout.city_list_item, cityList);
        listView.setAdapter(arrayAdapter);

        addCityButton = findViewById(R.id.addCityButtonID);
        deleteCityButton = findViewById(R.id.deleteCityButtonID);
        addCityLayout = findViewById(R.id.addCityLayoutID);
        addCityLayout.setVisibility(View.GONE);
        submitButton = findViewById(R.id.confirmButtonID);
        addCityText = findViewById(R.id.addCityTextID);
        submitButton.setOnClickListener(view -> {
            String city = addCityText.getText().toString();
            cityList.add(city);
            addCityLayout.setVisibility(view.GONE);
        });

        addCityButton.setOnClickListener(view -> {
            addCityLayout.setVisibility(view.VISIBLE);
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
               deleteCityButton.setOnClickListener(x ->{
                   cityList.remove(position);
                   arrayAdapter.notifyDataSetChanged();
               });

            }
        });
    }
}
package com.example.adaptersnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    String[] countries={"Бразилия","Аргентина","Россия","Чили","Франция"};
    String[] countries;
    private TextView selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countiesList=findViewById(R.id.countriesList);
        selection=findViewById(R.id.selection);
        countries=getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countries);
        countiesList.setAdapter(adapter);
        countiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=countries[i];
                selection.setText(selectedItem);
            }
        });

    }
}

package com.example.adaptersnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
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
        final ListView countiesList=findViewById(R.id.countriesList);
        selection=findViewById(R.id.selection);
        countries=getResources().getStringArray(R.array.countries);

//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countries);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,countries);
        countiesList.setAdapter(adapter);
        countiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String selectedItem=countries[i];
//                selection.setText(selectedItem);
                SparseBooleanArray sp=countiesList.getCheckedItemPositions();
                String selectedItems="";
                for(int c=0;i<countries.length;c++)
                {
                    if(sp.get(c)) selectedItems+=countries[c]+",";
                }
                selection.setText(selectedItems);
            }
        });

    }
}

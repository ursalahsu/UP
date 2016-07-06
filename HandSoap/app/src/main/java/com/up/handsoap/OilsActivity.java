package com.up.handsoap;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class OilsActivity extends AppCompatActivity {
    ListView oilsListview;
    String[] oilsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oils);

        oilsListview = (ListView) findViewById(R.id.oilsListView);
        oilsArray = getResources().getStringArray(R.array.oilsName);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,oilsArray);
    }

    private void checkReturn(){

    }

    private void checkCancel(){

    }
}

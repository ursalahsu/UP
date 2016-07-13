package com.up.handsoap;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OilsActivity extends AppCompatActivity {
    ListView oilsListview;
    String[] oilsArray;
    List<Oil> oils = new ArrayList<>();

    OilsAdapter oilsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oils);

        oilsListview = (ListView) findViewById(R.id.oilsListView);
        //取得油品清單
        oilsArray = getResources().getStringArray(R.array.oilsName);
//        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,oilsArray);
        oilsAdapter = new OilsAdapter(this,oilsArray);
        oilsListview.setAdapter(oilsAdapter);

        //設定可多選
        oilsListview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //點擊勾選
        oilsListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(oilsListview.isItemChecked(position)==true)
//                    oilsListview.getChildAt(position).setBackgroundColor(Color.RED);
//                else
//                    oilsListview.getChildAt(position).setBackgroundColor(Color.WHITE);
                Oil oil = new Oil();
                oil.setName(oilsArray[position]);
                oils.add(oil);
            }
        });
        //長按
        oilsListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    public void checkReturn(View view){
        Intent intent=new Intent();
        JSONArray jsonArray = new JSONArray();
        for(Oil oil:oils){
            JSONObject jsonObject=oil.getJsonObject();
            jsonArray.put(jsonObject);
        }
        intent.putExtra("oilsList",jsonArray.toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    public void checkCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}

package com.up.handsoap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button oilAddButton;
    ListView oilsListview;
    List<Oil> oilList=new ArrayList<>();
    OilsAdapter oilsAdapter;

    static int REQUEST_CODE_OILSACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oilAddButton = (Button) findViewById(R.id.addButton);
        oilsListview = (ListView) findViewById(R.id.oilsListView);

    }
    //增加油品項目
    public void addOils(View view){
//        Log.d("Debug","click");
        Intent intent = new Intent();
        intent.setClass(this,OilsActivity.class);
        startActivityForResult(intent,REQUEST_CODE_OILSACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //取回油品項目 列至oilsListView上
        if(requestCode==REQUEST_CODE_OILSACTIVITY){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,data.getStringExtra("results"),Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray= new JSONArray(data.getStringExtra("results"));
                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Oil oil=new Oil();
                        oil.setName(jsonObject.getString("name"));
                        oilList.add(oil);
                        setupListView();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if(resultCode==RESULT_CANCELED){

            }
        }
    }
    public void setupListView(){
        oilsAdapter = new OilsAdapter(this,(String[])oilList.toArray());
        oilsListview.setAdapter(oilsAdapter);
    }
}

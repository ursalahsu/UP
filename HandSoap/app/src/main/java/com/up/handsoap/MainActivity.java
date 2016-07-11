package com.up.handsoap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button oilAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oilAddButton = (Button) findViewById(R.id.addButton);
    }

    public void addOils(View view){
//        Log.d("Debug","click");
        Intent intent = new Intent();
        intent.setClass(this,OilsActivity.class);
        startActivity(intent);
    }
}

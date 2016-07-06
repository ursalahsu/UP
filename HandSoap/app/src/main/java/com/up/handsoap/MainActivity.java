package com.up.handsoap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button oilAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oilAddButton = (Button) findViewById(R.id.addButton);
    }

    private void oilsAdd(){
        Intent intent = new Intent();

    }
}

package com.dmv.astroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DetailsActivity extends AppCompatActivity {
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //DOM

        //Intent
        Intent getData = this.getIntent();

        if(getData != null){
            name = getData.getStringExtra("name");

        }
    }
}

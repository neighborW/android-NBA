package com.example.mrwang.nbademo2019;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrwang.nbademo2019.model.Race;
import com.example.mrwang.nbademo2019.model.adapter.MyAdapter;


import java.util.List;

public class RaceActivity extends AppCompatActivity {
    private ListView list_item = null;
    private MyAdapter myAdapter  ;
    Bundle bundle;
    private LinearLayout titlell;
    Intent intent;
    private Button eixt = null;

    List<Race>raceList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_race);

        list_item = (ListView) findViewById(R.id.list_item);
        eixt = (Button)findViewById(R.id.eixt);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        raceList = (List<Race>) bundle.getSerializable("race");


        list_item = (ListView) findViewById(R.id.list_item);
        myAdapter = new MyAdapter(raceList, RaceActivity.this);
        list_item.setAdapter(myAdapter);


        eixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raceList.clear();
            }
        });
    }


}

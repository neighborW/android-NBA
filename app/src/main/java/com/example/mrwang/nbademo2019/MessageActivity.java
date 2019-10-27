package com.example.mrwang.nbademo2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mrwang.nbademo2019.model.Point;
import com.example.mrwang.nbademo2019.model.Race;
import com.example.mrwang.nbademo2019.model.adapter.MyAdapter;
import com.example.mrwang.nbademo2019.model.adapter.PointAdapter;

import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private PointAdapter pointAdapter = null;
    private ListView list_point = null;
    Intent intent;
    private List<Point> list1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        //list_point = (ListView) findViewById(R.id.list_point);
        list_point = (ListView)findViewById(R.id.list_point);
        intent = getIntent();

        Bundle bundle = intent.getExtras();
        list1 = (List<Point>) bundle.getSerializable("point");

        list_point = (ListView)findViewById(R.id.list_point);
        pointAdapter = new PointAdapter(list1, MessageActivity.this);
        list_point.setAdapter(pointAdapter);

    }
}

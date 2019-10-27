package com.example.mrwang.nbademo2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {
    private TextView ed1 = null;
    private TextView ed2 = null;
    private TextView ed3 = null;
    private TextView ed4 = null;
    private TextView ed5 = null;
    private TextView ed6 = null;
    private TextView ed7 = null;
    private TextView ed8 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ed1 = (TextView)findViewById(R.id.ed1);
        ed2 = (TextView)findViewById(R.id.ed2);
        ed3 = (TextView)findViewById(R.id.ed3);
        ed4 = (TextView)findViewById(R.id.ed4);
        ed5 = (TextView)findViewById(R.id.ed5);
        ed6 = (TextView)findViewById(R.id.ed6);
        ed7 = (TextView)findViewById(R.id.ed7);
        ed8 = (TextView)findViewById(R.id.ed8);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();///获取前面的那个activity传过来的数据
        ed1.setText(bundle.getString("playerteam"));
        ed2.setText(bundle.getString("playername"));
        ed3.setText(bundle.getString("playernumber"));
        ed4.setText(bundle.getString("playerjob"));
        ed5.setText(bundle.getString("playertall"));
        ed6.setText(bundle.getString("playerweight"));
        ed7.setText(bundle.getString("playercon"));
        ed8.setText(bundle.getString("playersal"));
    }
}

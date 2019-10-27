package com.example.mrwang.nbademo2019;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrwang.nbademo2019.model.Point;
import com.example.mrwang.nbademo2019.model.Race;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private Button newsbtn = null;
    private Button racebtn = null;
    private Button plaryerbtn = null;
    private Button messagebtn = null;

    private Button select = null;
    private EditText sele = null;

    private static final int REQUEST_PERMISSION_CODE = 1;
    private static String[] PERMISSIONS_INTERNET = {Manifest.permission.INTERNET};

    static Toast t;

    public  Race race = null;
    public Point point = null;
    String []racestr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newsbtn = (Button)findViewById(R.id.newsbtn);
        racebtn = (Button)findViewById(R.id.racebtn);
        plaryerbtn = (Button)findViewById(R.id.plaryerbtn);
        messagebtn = (Button)findViewById(R.id.messagebtn);

        select = (Button)findViewById(R.id.select);
        sele = (EditText) findViewById(R.id.sele);

        racebtn.setOnClickListener(new MyLisenter());
        plaryerbtn.setOnClickListener(new MyLisenter());
        messagebtn.setOnClickListener(new MyLisenter());

        select.setOnClickListener(new Mylisenter1());

        plaryerbtn.setOnClickListener(new Mylisenter2());

    }
    class MyLisenter implements View.OnClickListener{
        //String[] s = new String[null,null];
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        Bundle  bundle;
        String  []str = null;

        List<Race> list1= new ArrayList<>();
        /*
        获取赛程
         */
        @Override
        public void onClick(View view) {
            @SuppressLint("HandlerLeak")
            Handler handler = new Handler() {

                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 1:
                            List<HashMap<String, String>> list = JSONTOOL.analyze_some_json(msg.obj.toString());
                            for(int i = 0;i<list.size();i++){

                                race = new Race(list.get(i).get("raceday"),list.get(i).get("racetime"),list.get(i).get("hometeam"),list.get(i).get("guestteam"));
                                list1.add(race);
                            }
                            Intent intent = new Intent(HomeActivity.this, RaceActivity.class);
                            bundle = new Bundle();
                            bundle.putSerializable("race",(Serializable)list1);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            break;
                        case 0:
                            t = Toast.makeText(HomeActivity.this, "無網絡連接", Toast.LENGTH_LONG);//淇℃伅妗?
                            t.show();
                            break;
                    }
                    super.handleMessage(msg);
                }
            };
            switch (view.getId()){
                case R.id.racebtn:
                    client.get("http://192.168.43.217:8000/racerange/",
                            new MyTextListener(handler, 3, 30));
                break;
                case R.id.plaryerbtn:
                case R.id.messagebtn:
            }
        }
    }
    class Mylisenter1 implements View.OnClickListener{
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        @Override
        public void onClick(View view) {
            @SuppressLint("HandlerLeak")
            Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 3:
                            HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                            String s1 = map.get("playerteam");
                            String s2 = map.get("playername");
                            String s3 = map.get("playernumber");
                            String s4 = map.get("playerjob");
                            String s5 = map.get("playertall");
                            String s6 = map.get("playerweight");
                            String s7 = map.get("playercon");
                            String s8 = map.get("playersal");
                            t = Toast.makeText(HomeActivity.this, "查询成功", Toast.LENGTH_LONG);//淇℃伅妗?
                            Intent intent = new Intent(HomeActivity.this, SelectActivity.class);
                            intent.putExtra("playerteam",s1);
                            intent.putExtra("playername",s2);
                            intent.putExtra("playernumber",s3);
                            intent.putExtra("playerjob",s4);
                            intent.putExtra("playertall",s5);
                            intent.putExtra("playerweight",s6);
                            intent.putExtra("playercon",s7);
                            intent.putExtra("playersal",s8);
                            startActivity(intent);
                            break;
                        case 30:
                            t = Toast.makeText(HomeActivity.this, "查询失败", Toast.LENGTH_LONG);//淇℃伅妗?
                            t.show();
                            break;
                    }
                    super.handleMessage(msg);
                }
            };
            params.put("method", "_GET");
            params.put("table", "playermsg");
            params.put("playername", sele.getText().toString());
            client.post("http://192.168.43.217:8000/android_playermsg/", params,
                    new MyTextListener(handler, 3, 30));
        }
    }
    class Mylisenter2 implements View.OnClickListener{

        AsyncHttpClient client = new AsyncHttpClient();
        List<Point> list2 = new ArrayList<>();
        Bundle  bundle;

        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {

            public void handleMessage(Message msg) {

                switch (msg.what) {
                    case 3:
                        List<HashMap<String, String>> list = JSONTOOL.analyze_some_json(msg.obj.toString());
                        for(int i = 0;i<list.size();i++){
                            point = new Point(list.get(i).get("playerteam"),
                                                list.get(i).get("playername"),
                                                list.get(i).get("playerscore"),
                                                list.get(i).get("playershotIn"),
                                                list.get(i).get("playerthreeIn"));
                            list2.add(point);
                        }
                        Intent intent = new Intent(HomeActivity.this, MessageActivity.class);
                        bundle = new Bundle();
                        bundle.putSerializable("point",(Serializable)list2);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 30:
                        t = Toast.makeText(HomeActivity.this, "無網絡連接", Toast.LENGTH_LONG);//淇℃伅妗?
                        t.show();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        @Override
        public void onClick(View view) {
            client.get("http://192.168.43.217:8000/playerpoint/",
                    new MyTextListener(handler, 3, 30));
        }
    }
    public void NBAnews(View view){
    Uri uri = Uri.parse("https://voice.hupu.com/nba");//要跳转的网址
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(intent);}
}



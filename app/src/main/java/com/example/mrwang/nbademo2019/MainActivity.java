package com.example.mrwang.nbademo2019;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 1;
    private static String[] PERMISSIONS_INTERNET = {Manifest.permission.INTERNET};

    private static final String TAG = "MainActivity";

    private EditText useNameEt = null;
    private EditText passwordEt = null;

    public Button register = null;
    private Button loginbtn = null;
    static Toast t;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register =  (Button) findViewById(R.id.register);
        register.setOnClickListener(new MyLisener());

        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new MyLisener());

        useNameEt = (EditText) findViewById(R.id.useNameEt);
        passwordEt = (EditText) findViewById(R.id.passwordEt);


    }

    class MyLisener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            @SuppressLint("HandlerLeak")
            Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 3:
                            HashMap<String,String> map = JSONTOOL.analyze_once_json(msg.obj.toString());
                            //String s = map.get("username");
                            t = Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG);//淇℃伅妗?
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                            break;
                        case 30:
                            t = Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG);//淇℃伅妗?
                            t.show();
                            break;
                    }
                    super.handleMessage(msg);
                }
            };
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            switch (v.getId()) {
                case R.id.loginbtn:
                    params.put("method", "_GET");
                    params.put("table", "user");
                    params.put("username", useNameEt.getText().toString());
                    params.put("password", passwordEt.getText().toString());
                    client.post("http://192.168.43.217:8000/android_user/", params,
                            new MyTextListener(handler, 3, 30));
                    break;
                case R.id.register:
                    Intent intent = new Intent(MainActivity.this, EnrollActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}

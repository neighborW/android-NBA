package com.example.mrwang.nbademo2019;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

import static com.example.mrwang.nbademo2019.R.id.rester;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
public class EnrollActivity extends AppCompatActivity {

    private static final String TAG = "EnrollActivity";

    private EditText editRe1 = null;
    private EditText editRe2 = null;
    private EditText editRe3 = null;
    private EditText editRe4 =null;
    private Button rester = null;
    static Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);
        editRe1 = findViewById(R.id.editRe1);
        editRe2 = findViewById(R.id.editRe2);
        editRe3 = findViewById(R.id.editRe3);
        editRe4 = findViewById(R.id.editRe4);
        rester = findViewById(R.id.rester);
        rester.setOnClickListener(new Mylisenter());
    }
    class Mylisenter implements View.OnClickListener {

        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        HashMap map = JSONTOOL.analyze_once_json(msg.obj.toString());
                        t = Toast.makeText(EnrollActivity.this, "注册成功", Toast.LENGTH_LONG);//淇℃伅妗?
                        Intent intent = new Intent(EnrollActivity.this, MainActivity.class);
                        startActivity(intent);
                        EnrollActivity.this.finish();
                        break;
                    case 0:
                        t = Toast.makeText(EnrollActivity.this, "信息不符合标准,注册失败", Toast.LENGTH_LONG);//淇℃伅妗?
                        t.show();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        @Override
        public void onClick(View v) {
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();

                    params.put("method", "_POST");
                    params.put("table", "user");
                    params.put("username", editRe1.getText().toString());
                    params.put("password", editRe2.getText().toString());
                    params.put("phonenumber", editRe3.getText().toString());
                    params.put("confirmpasswd",editRe4.getText().toString());
                    String  password1 = null;
                    String password2 = null;
                    password1 = (String) editRe2.getText().toString();
                    password2 = (String) editRe4.getText().toString();
                    if(password1.equals(password2) )
                    {
                        client.post("http://10.0.116.13:8080/user/client_register", params,
                                new MyTextListener(handler, 1, 0));
                    }
                    else {
                        t = Toast.makeText(EnrollActivity.this, "密码不一致", Toast.LENGTH_LONG);//淇℃伅妗?
                        t.show();
                    }
        }
    }
}

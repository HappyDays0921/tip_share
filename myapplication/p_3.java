package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class p_3 extends AppCompatActivity {
    Button btn_back,wrt_article;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_3);

        String number = "1";
        //테이블에서 p_1에 맞는 글 가져오는 부분
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success){
                        Toast.makeText(getApplication(),"성공",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(getApplication(),"실패",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                catch(JSONException e){
                    e.printStackTrace();

                }
            }
        };
        p_1_Request p1Request = new p_1_Request(number,responseListener);
        RequestQueue queue = Volley.newRequestQueue(p_3.this);
        queue.add(p1Request);




        //뒤로가기 버튼
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });
        //글쓰기 버튼
        wrt_article = (Button) findViewById(R.id.wrt_article);
        wrt_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),about.class);
                startActivity(intent);
            }
        });



    }

}

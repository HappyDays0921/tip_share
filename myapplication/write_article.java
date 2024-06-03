package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class write_article extends AppCompatActivity {
    EditText write_article;
    Button confirm_button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_article);

        write_article = findViewById(R.id.write_article);

        //여기 필요한거
        //userID, subject, article, upload_time,like_cnt,article_nmb
        //upload_time php 함수에 있음, (like_cnt = 0, article_nmb=1 )default

        //SharedPreferences를 통해 userID를 받아와야함
        //또한 전 페이지에서 subject도 받아와야함
        //사용자가 입력 가능한것은 article 하나임

        //일단 이거 내가 임의로 지정
        String userID = "tst_userID";
        String subject = "2";


        confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String article = write_article.getText().toString();
                Response.Listener<String>responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(write_article.this, "데이터 전송 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(write_article.this,p_1.class);
                            startActivity(intent);
                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                write_article_Request writeArticleRequest = new write_article_Request(userID,subject,article,responseListener);
                RequestQueue queue = Volley.newRequestQueue(write_article.this);
                queue.add(writeArticleRequest);


            }
        });




    }
}

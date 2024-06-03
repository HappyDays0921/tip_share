package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class p_1 extends AppCompatActivity {
    Button btn_back,wrt_article;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_1);

        String[] itemNames = {"test1","test2","test3","test4","test5"};
        //final String[] itemNames = new String[50];
        final String[] url = new String[50];

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemNames);
        ListView listView = findViewById(R.id.p1_listview);
        listView.setAdapter(adapter);

        //(글 종류)subject : 1번 글
        String subject ="1";
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            //String data 할때 data가 php의 encoding 되는 json과 같아야 가져와지는듯?
            //어 아닌듯?? 머노 이거
            public void onResponse(String data) {
                try{
                    JSONObject jsonObject = new JSONObject(data);
                    boolean success = jsonObject.getBoolean("success");
                    String cnt = jsonObject.getString("size");
                    int size = Integer.parseInt(cnt);
                    String[] size_arr=new String[size];
                    String[] article = new String[size];
                    //배열 size_arr 정의
                    //json 형식으로 주는 자료가 str 형 숫자 12345 이모양이라
                    //키 값을 받으려고 배열 만듬
                    //귀찮으면 유니코드값으로 하면 될듯
                    //그냥 toString(i)해서 넣으면 안되는건가
                    //왜 뻘짓함
                    for(int i=0;i<size;i++){
                        size_arr[i] = String.valueOf(i);
                    }
                    //본격적으로 article배열에 글 내용 집어넣기
                    for(int i=0;i<size;i++) {
                        article[i] = jsonObject.getString(size_arr[i]);
                        itemNames[i] = article[i];

                    }

                    //========listview 만들어보기(여기 시도중)=======




                    //이거는 여기까지 문제 없이 오는지 확인하기위해서 만든 if문
                    if(!success)
                        Toast.makeText(getApplication(),"성공",Toast.LENGTH_SHORT).show();

                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        p_1_Request p1Request = new p_1_Request(subject,responseListener);
        RequestQueue queue = Volley.newRequestQueue(p_1.this);
        queue.add(p1Request);


        //글쓰기 버튼 활성화
        wrt_article = (Button) findViewById(R.id.wrt_article);
        wrt_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),write_article.class);
                startActivity(intent);
            }
        });

    }


}
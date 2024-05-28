package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class p_2 extends AppCompatActivity {
    Button btn_back,wrt_article;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_1);

        String[] itemNames = {"test1","test2","test3","test4","test5"};
        String[] url={"https://chungjuc.com/product/detail.html?product_no=25&srsltid=AfmBOopijCoPckmryEwvYYKt5yiVsYNFqdthcACyZjugmzwhSCYuqcQzXXY",
                "https://mfruta.shop/product/detail.html?product_no=14&srsltid=AfmBOoqCcu_80hH0yU1ij4irRjfvOx3Me1FgZWgQwCyil9KLhWAGCXidlfA",
                "https://shopping.naver.com/window-products/directfarm/8789651742?NaPm=ct%3Dlros1rm0%7Cci%3D0fc20623de298e1a3ea6945f5e740545263927b5%7Ctr%3Dsls%7Csn%3D4693082%7Chk%3Dca622b1ecfff5749b91df1f26bf1abca926a8749"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemNames);

        ListView listView = findViewById(R.id.p1_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });



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

package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class about extends AppCompatActivity {
    //한 페이지에서 버튼을 여러번 눌러서 좋아요 올리는거 방지
    boolean like_button_pressed = false;
    Button btn_back,like;
    TextView like_nmb,writedown,time;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        //article 내용 표시
        writedown = (TextView)findViewById(R.id.writedown);
        //좋아요 숫자 표시
        like_nmb = (TextView)findViewById(R.id.like_nmb);
        //article 작성 년/월/일 표시
        time = (TextView) findViewById(R.id.time);


        //userID랑 subject, article은 intent로 넘겨서 받자

        //==========여기 수정 필요==========
        String userID = "tst_userID";
        String article="qwer";
        String subject = "2";
        //==========여기 수정 필요==========


        final String[] number = {"0"};
        //글 가져오기
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String like_cnt = jsonObject.getString("like_cnt");
                    String uploadTime = jsonObject.getString("upload_time");
                    writedown.setText(article);
                    like_nmb.setText(like_cnt);
                    time.setText(uploadTime);
                    Toast.makeText(getApplication(),"성공",Toast.LENGTH_SHORT).show();
                    number[0] = like_cnt;
                }
                catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        about_Request aboutRequest = new about_Request(userID, article, subject,responseListener);
        RequestQueue queue = Volley.newRequestQueue(about.this);
        queue.add(aboutRequest);

        //뒤로가기 버튼 활성화
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),p_1.class);
                startActivity(intent);
            }
        });

        //like 버튼 활성화
        like = (Button)findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //like_buttonn_pressed를 통해서 한 페이지에서 여러번 눌렀을때 한번만 숫자가 올라가게 조정
                //페이지를 나갔다가 들어와서 다시 누르면 다시 눌림....ㅜ
                if(!like_button_pressed){
                    like_button_pressed = true;
                    int add_number = Integer.parseInt(number[0]);
                    add_number++;
                    like_nmb.setText(String.valueOf(add_number));

                //php문에서 +1을 해서 조금 코드가 더럽게 되었음
                //about_like_Request에서 해당되는 php url 동작.
                //보낼때 userID,subject,article,changed_number를 보내서 해당되는 글을 찾는다.
                //애당초에 article_nmb 사용했으면 해결될 문제...
                //일단 데모버젼 출시하고 바꿀때 article_nmb를 사용
                Response.Listener<String> responseListener1 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String data) {
                        try {
                            JSONObject jsonObject1 = new JSONObject(data);
                            //Toast.makeText(getApplication(),"성공",Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //
                String changed_number = number[0];
                about_like_Request aboutLikeRequest = new about_like_Request(userID, subject, article, changed_number, responseListener1);
                RequestQueue queue1 = Volley.newRequestQueue(about.this);
                queue1.add(aboutLikeRequest);
                }
            }
        });


    }
}

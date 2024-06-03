package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class create_account extends AppCompatActivity {

    //버튼 변수 정의
    Button btn_back,btn_create_account_finish;
    //EditText 변수 정의
    EditText input_id, input_name,input_pw,input_pw2,input_phone_number,input_email;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);


        //EditText 활성화
        input_id = findViewById(R.id.input_id);
        input_pw = findViewById(R.id.input_pw);
        input_name = findViewById(R.id.input_name);
        input_pw2 = findViewById(R.id.input_pw2);
        input_phone_number = findViewById(R.id.input_phone_number);
        input_email = findViewById(R.id.input_email);

        //뒤로가기 버튼
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),login.class);
                startActivity(intent);
            }
        });
        //누르면 '회원가입 완료' 버튼
        //btn_create_account_finish
        btn_create_account_finish = findViewById(R.id.btn_create_account_finish);
        btn_create_account_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = input_id.getText().toString();
                String userPassword = input_pw.getText().toString();
                String pwchck = input_pw2.getText().toString();
                String userName = input_name.getText().toString();
                String phoneNumber = input_phone_number.getText().toString();
                String email = input_email.getText().toString();

                if (!userPassword.equalsIgnoreCase(pwchck)) {
                    Toast.makeText(getApplicationContext(), "비밀번호와 확인이 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Response.Listener<String>responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplication(),"회원 등록 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(create_account.this,login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplication(),"회원 등록 실패",Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                //request 클래스를 만들어서 정렬된 데이터 형태로 queue에 add
                create_account_Request createAccountRequest = new create_account_Request(userID,userPassword,userName,phoneNumber,email,responseListener);
                RequestQueue queue = Volley.newRequestQueue(create_account.this);
                queue.add(createAccountRequest);


            }
        });

    }
}

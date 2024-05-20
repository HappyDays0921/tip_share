package com.example.fit_fresh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class create_account extends AppCompatActivity {

    Button btn_back,btn_create_account_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),login.class);
                startActivity(intent);
            }
        });
        btn_create_account_finish = (Button) findViewById(R.id.btn_create_account_finish);
        btn_create_account_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),login.class);
                startActivity(intent);
            }
        });

    }





}

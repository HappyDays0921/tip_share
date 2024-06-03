package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class tst_activity extends AppCompatActivity {
    ArrayList<SampleData> movieDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeMovieData();
        ListView listView = (ListView)findViewById(R.id.p1_listview);
        final MyAdapter myAdapter = new MyAdapter(this,movieDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getMovieName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    public void InitializeMovieData(){
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData(R.drawable.movieposter1_background,"movieName1","Grade1"));
        movieDataList.add(new SampleData(R.drawable.movieposter1_background,"movieName2","Grade2"));
        movieDataList.add(new SampleData(R.drawable.movieposter1_background,"movieName3","Grade3"));
    }

}

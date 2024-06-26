package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;
    public MyAdapter(Context context, ArrayList<SampleData>data){
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public SampleData getItem(int position) {
        return sample.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_custom,null);


        ImageView imageview = (ImageView)view.findViewById(R.id.poster);
        TextView movieName = (TextView) view.findViewById(R.id.movieName);
        TextView grade = (TextView)view.findViewById(R.id.grade);

        imageview.setImageResource(sample.get(position).getPoster());
        movieName.setText(sample.get(position).getMovieName());
        grade.setText(sample.get(position).getGrade());

        return view;
    }
}

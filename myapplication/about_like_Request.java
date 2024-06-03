package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class about_like_Request extends StringRequest {
    static private String URL = "http://tipshare.dothome.co.kr/about_like.php";
    public Map<String, String> map;

    public about_like_Request(String userID, String subject, String article,String like_cnt, Response.Listener<String>listener){
        super(Method.POST, URL, listener,null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("subject",subject);
        map.put("article",article);
        map.put("like_cnt",like_cnt);
    }
    @Override
    protected Map<String,String> getParams()throws AuthFailureError{
        return map;
    }
}

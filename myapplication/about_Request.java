package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class about_Request extends StringRequest {

    static private String URL = "http://tipshare.dothome.co.kr/about.php";
    public Map<String,String> map;
    public about_Request(String userID, String article,String subject, Response.Listener<String>listener){
        super(Method.POST, URL,listener,null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("article",article);
        map.put("subject",subject);
    }
    @Override
    protected Map<String,String> getParams() throws AuthFailureError{
        return map;
    }

}

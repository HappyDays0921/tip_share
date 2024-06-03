package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class write_article_Request extends StringRequest {
    static private String URL = "http://tipshare.dothome.co.kr/write.php";
    private Map<String, String> map;
    public write_article_Request(String userID, String subject, String article, Response.Listener<String>listener){
        super(Method.POST, URL,listener,null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("subject",subject);
        map.put("article",article);
    }
    @Override
    protected Map<String,String>getParams() throws AuthFailureError{
        return map;
    }

}

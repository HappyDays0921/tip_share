package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class p_1_Request extends StringRequest {
    static private String URL = "http://tipshare.dothome.co.kr/view_arr1.php";
    public Map<String,String> map;
    public p_1_Request(String subject,Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        map = new HashMap<>();
        map.put("subject",subject);
    }
    @Override
    protected Map<String,String> getParams() throws AuthFailureError{
        return map;
    }




}

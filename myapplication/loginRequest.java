package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class loginRequest extends StringRequest {
    final static private String URL= "http://tipshare.dothome.co.kr/login.php";
    public Map<String,String> map;
    public loginRequest(String userID, String userPassword, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}

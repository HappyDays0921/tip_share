package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class create_account_Request extends StringRequest {
    static private String URL ="http://tipshare.dothome.co.kr/createAccount.php";
    private Map<String, String> map;
    public create_account_Request(String userID, String userPassword, String userName, String phoneNumber, String email, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("phoneNumber",phoneNumber);
        map.put("email",email);
    }
    @Override
    protected Map<String,String> getParams() throws AuthFailureError{
        return map;
    }
}

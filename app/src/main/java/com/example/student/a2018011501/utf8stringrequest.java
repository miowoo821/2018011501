package com.example.student.a2018011501;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by Student on 2018/1/15.
 */

public class utf8stringrequest extends StringRequest {

//    public utf8stringrequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
//        super(method, url, listener, errorListener);
//    }這個建構式多一個參數，這樣MainActivity的request會錯，因為只寫三個參數，所以用下面的建構式就好，
    public utf8stringrequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        // TODO Auto-generated method stub
        String str = null;
        try {
            str = new String(response.data,"utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
    }
}

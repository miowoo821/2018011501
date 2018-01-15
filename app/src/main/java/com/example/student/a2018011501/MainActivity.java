package com.example.student.a2018011501;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){

        //Volley有四個步驟
        RequestQueue queue =Volley.newRequestQueue(MainActivity.this);
        //ImageRequest(VOLLEY抓圖)有七個參數：
        // 1.圖片網址，
        // 2.抓成功之後處理，
        // 3.最大寬，
        // 4.最大高，
        // 5.長寬與元件的比例，
        // 6.RGB??，
        // 7.抓失敗的處理
        ImageRequest request=new ImageRequest("http://www.lolpix.com/_pics/Funny_Pictures_743/Funny_Pictures_7435.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        img.setImageBitmap(response);
                    }
                },0,0, ImageView.ScaleType.FIT_XY,Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
    public void click2(View v)
    {
        // volley預設中文編碼ansi-big5,要轉utf8,寫一個新的CLASS覆寫他
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new utf8stringrequest("https://www.mobile01.com/rss/news.xml",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
}

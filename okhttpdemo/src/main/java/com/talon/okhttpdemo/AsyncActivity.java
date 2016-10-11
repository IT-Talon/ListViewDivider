package com.talon.okhttpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AsyncActivity extends AppCompatActivity implements Handler.Callback {
    private OkHttpClient client = null;
    private TextView mTextView = null;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        client = new OkHttpClient();
        mTextView = (TextView) findViewById(R.id.TextView_asyncTxt);
        handler = new Handler(this);
        getAsyncString();
    }

    private void getAsyncString() {
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(UrlConfig.MOVIE_URL).build();
        Response response = null;
       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {

           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
               Message message = handler.obtainMessage();
               message.obj = result;
               handler.sendMessage(message);
           }
       });

    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg!=null){
            mTextView.setText((String)msg.obj);
        }
        return false;
    }
}

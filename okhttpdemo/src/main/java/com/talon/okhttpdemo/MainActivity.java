package com.talon.okhttpdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    private OkHttpClient okHttpClient = null;
    private Handler handle = null;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView_result);
        okHttpClient = new OkHttpClient();
        handle = new Handler(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getString();
            }
        }).start();
//        startActivity(new Intent(MainActivity.this,AsyncActivity.class));
    }

    private void getString() {
        Request request = new Request.Builder().get().url(UrlConfig.MOVIE_URL).build();
        Response response = null;

        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.isSuccessful()) {
            try {
                final String result = response.body().string();
                //方法一
//                mTextView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mTextView.setText(result);
//                    }
//                });
                //方法二
//                Message message = handle.obtainMessage();
//                message.what = 1;
//                message.obj = result;
//                handle.sendMessage(message);

                //方法三
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText(result);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg != null) {
            mTextView.setText((String) msg.obj);
        }
        return false;
    }
}

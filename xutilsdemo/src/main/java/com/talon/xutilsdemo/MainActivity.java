package com.talon.xutilsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.imageView)
    private ImageView mImageView;
    @ViewInject(R.id.button)
    private Button mButton;
    @ViewInject(R.id.textView)
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        mImageView.setImageResource(R.mipmap.ic_launcher);
        mTextView.setText("注解是啥？");
        mButton.setText("注解按钮");
    }
    @Event(R.id.button)
    private void onClick(View view){
        Toast.makeText(this, "zhujietoast", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,ActivityTwo.class));
    }


}

package com.talon.xutilsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ActivityTwo extends AppCompatActivity {
    @ViewInject(R.id.fragment)
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        x.view().inject(this);
    }
}

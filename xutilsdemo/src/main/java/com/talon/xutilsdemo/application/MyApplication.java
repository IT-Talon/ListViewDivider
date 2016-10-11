package com.talon.xutilsdemo.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Talon on 2016/9/29.
 * Talon
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}

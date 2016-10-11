package com.lol.myeventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv_main);
        // 为listview设置数据（没有改变图片，仅仅设置了不同的title）
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title", "Talon" + i);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.listview_item, new String[]{"title"},
                new int[]{R.id.tv_item});
        mListView.setAdapter(adapter);
    }
}

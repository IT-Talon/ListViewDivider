package com.talon.recyclerviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> list;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("talon" + i);
        }
        recyclerView.setAdapter(new MyAdapter(this, list));
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
}

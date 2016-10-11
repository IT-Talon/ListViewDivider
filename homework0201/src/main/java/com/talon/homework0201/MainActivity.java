package com.talon.homework0201;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.talon.homework0201.adapter.MyViewPageAdapter;
import com.talon.homework0201.fragment.FragmentOne;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setToolbar();
        mViewPager.setAdapter(new MyViewPageAdapter(getSupportFragmentManager(),fragmentList,titleList));
        mTablayout.setupWithViewPager(mViewPager);

    }

    private void initData() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fragmentList.add(new FragmentOne());
            titleList.add("kk" + i);
        }
    }

    private void setToolbar() {
        mToolbar.setTitle("Toolbar");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setSubtitle("ToolbarSubTitle");
//        for (int i = 0; i < 5; i++) {
//            mTablayout.addTab(mTablayout.newTab().setText("tab" + i).setIcon(R.mipmap.tab4));
//        }


    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_coordinatorlayout);
        mTablayout = (TabLayout) findViewById(R.id.tablayout_coordinatorlayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_coordinatorlayout);
    }
}

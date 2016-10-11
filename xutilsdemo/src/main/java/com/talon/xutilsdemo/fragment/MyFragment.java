package com.talon.xutilsdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.talon.xutilsdemo.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    @ViewInject(R.id.listView)
    private ListView mListView;


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_my, container, false);
        x.view().inject(this,inflate);
        mListView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, new String[]{"talon1", "talon2", "talon3"}));
        return inflate;
    }

}

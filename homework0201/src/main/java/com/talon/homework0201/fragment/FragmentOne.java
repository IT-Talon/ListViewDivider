package com.talon.homework0201.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.talon.homework0201.R;
import com.talon.homework0201.adapter.FragmentAdapter;
import com.talon.homework0201.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private RecyclerView mRecyclerView;
    private List<String> list;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_one, container, false);
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Talon" + i);
        }
        mRecyclerView.setAdapter(new MyRecyclerAdapter(getContext(),list));
        return inflate;
    }

}

package com.talon.recyclerviewdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Talon on 2016/9/26.
 * Talon
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> list;
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View inflater = null;
        switch (viewType) {
            case TYPE_ONE:
                inflater = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
                holder = new MyViewHolder1(inflater);
                break;
            case TYPE_TWO:
                inflater = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
                holder = new MyViewHolder2(inflater);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            ((MyViewHolder1) holder).img.setImageResource(R.mipmap.button);
        } else if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).btn.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView img;

        public MyViewHolder1(View inflater) {
            super(inflater);
            img = (ImageView) inflater.findViewById(R.id.imageView);
        }
    }

    private class MyViewHolder2 extends RecyclerView.ViewHolder {
        Button btn;

        MyViewHolder2(View inflater) {
            super(inflater);
            btn = (Button) inflater.findViewById(R.id.button);
        }
    }
}

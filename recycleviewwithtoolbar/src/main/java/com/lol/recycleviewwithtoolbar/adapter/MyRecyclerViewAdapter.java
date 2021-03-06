package com.lol.recycleviewwithtoolbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lol.recycleviewwithtoolbar.R;
import com.lol.recycleviewwithtoolbar.viewholder.RecyclerHeaderViewHolder;
import com.lol.recycleviewwithtoolbar.viewholder.RecyclerItemViewHolder;

import java.util.List;

/**
 * Created by Talon on 2016/10/8.
 * Talon
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;
    private List<String> mItemList;

    public MyRecyclerViewAdapter(List<String> mItemList) {
        this.mItemList = mItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
            return new RecyclerItemViewHolder(view);

        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(context).inflate(R.layout.recycler_header, parent, false);
            return new RecyclerHeaderViewHolder(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.setItemText(mItemList.get(position));
        if (!isPositionHeader(position)) {
            RecyclerItemViewHolder itemHolder = (RecyclerItemViewHolder) holder;
            String itemText = mItemList.get(position - 1); // we are taking header in to account so all of our items are correctly positioned
            itemHolder.setItemText(itemText);
        }
    }

    private int getBasicItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    //our new getItemCount() that includes header View
    @Override
    public int getItemCount() {
        return getBasicItemCount() + 1; // header
    }

    //added a method that returns viewType for a given position
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    //added a method to check if given position is a header
    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}

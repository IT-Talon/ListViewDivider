package com.lol.recycleviewwithtoolbar.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lol.recycleviewwithtoolbar.R;

/**
 * Created by Talon on 2016/10/8.
 * Talon
 */

public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    private TextView mItemTextView;

    public RecyclerItemViewHolder(View itemView) {
        super(itemView);
        mItemTextView = (TextView) itemView.findViewById(R.id.itemTextView);
    }

    public void setItemText(CharSequence text) {
        mItemTextView.setText(text);
    }
}

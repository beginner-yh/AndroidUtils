package com.yh.utils.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yh.utils.R;

import java.util.ArrayList;

/**
 * 类说明：主页面列表适配器
 *
 * @author yh
 * @date 2019/1/8
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<String> mData;
    private OnItemClick onItemClick;

    public MainListAdapter(Context mContext, ArrayList<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MainListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_rv_main_list, viewGroup, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainListAdapter.MyHolder viewHolder, int i) {
        viewHolder.btnTitle.setText(mData.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(viewHolder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private AppCompatButton btnTitle;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            btnTitle = itemView.findViewById(R.id.btn_title);
        }
    }


    public interface OnItemClick {

        /**
         * Item点击事件
         *
         * @param position Item点击的position
         */
        void onItemClick(int position);
    }
}

package com.yh.utils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yh.utils.R;
import com.yh.utils.bean.BaseItemBean;

import java.util.List;

/**
 * 设备信息列表适配器
 *
 * @author yh
 * @date 2019/1/9
 */
public class DeviceInfoAdapter extends RecyclerView.Adapter<DeviceInfoAdapter.MyHolder> {

    private Context mContext;
    private List<BaseItemBean> mData;

    public DeviceInfoAdapter(Context mContext, List<BaseItemBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public DeviceInfoAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_rv_device_info, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(DeviceInfoAdapter.MyHolder holder, int position) {
        BaseItemBean baseItemBean = mData.get(position);
        holder.tvTitle.setText(baseItemBean.getTitle());
        holder.tvContent.setText(baseItemBean.getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvContent;

        MyHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_context);
        }
    }
}

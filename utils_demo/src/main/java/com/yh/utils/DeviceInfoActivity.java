package com.yh.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yh.utils.adapter.DeviceInfoAdapter;
import com.yh.utils.bean.BaseItemBean;
import com.yh.utilslib.ManufacturerInfoUtils;
import com.yh.utilslib.NavigationBarUtils;
import com.yh.utilslib.ScreenInfoUtils;
import com.yh.utilslib.SystemUiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 屏幕信息展示界面
 *
 * @author yh
 * @date 2019/01/08
 */
public class DeviceInfoActivity extends AppCompatActivity {

    private RecyclerView rvShowDeviceInfo;


    public static void openSelf(Context context) {
        Intent intent = new Intent(context, DeviceInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        setTitle("设备信息");
        initView();
        initData();
    }

    private void initView() {
        rvShowDeviceInfo = findViewById(R.id.rv_show_device_info);
    }

    private void initData() {
        List<BaseItemBean> mData = new ArrayList<>();
        mData.add(new BaseItemBean("手机厂商", ManufacturerInfoUtils.getCurrentDeviceManufacturer()));
        mData.add(new BaseItemBean("手机UI系统", SystemUiUtils.getSystemUi()));
        mData.add(new BaseItemBean("手机UI系统版本", SystemUiUtils.getSytemUiVersion()));
        mData.add(new BaseItemBean("刘海屏设备", ""));
        mData.add(new BaseItemBean("屏幕高度", ScreenInfoUtils.getScreenHeight(this) + "px"));
        mData.add(new BaseItemBean("屏幕实际高度", ScreenInfoUtils.getRealHeight(this) + "px"));
        mData.add(new BaseItemBean("屏幕宽度", ScreenInfoUtils.getScreenWidth(this) + "px"));
        mData.add(new BaseItemBean("屏幕实际宽度", ScreenInfoUtils.getRealWidth(this) + "px"));
        mData.add(new BaseItemBean("StatusBar Height", ScreenInfoUtils.getStatusBarHeight(this) + "px"));
        mData.add(new BaseItemBean("NavigationBar Height", ScreenInfoUtils.getNavigationBarHeight(this) + "px"));
        mData.add(new BaseItemBean("NavigationBar 显示", NavigationBarUtils.hasNavigationBarCompat(this) ? "显示" : "不显示"));
        DeviceInfoAdapter adapter = new DeviceInfoAdapter(this, mData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvShowDeviceInfo.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvShowDeviceInfo.setLayoutManager(layoutManager);
        rvShowDeviceInfo.setAdapter(adapter);
    }
}

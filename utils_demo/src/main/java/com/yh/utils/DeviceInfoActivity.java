package com.yh.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yh.utilslib.ManufacturerInfoUtils;

/**
 * 屏幕信息展示界面
 *
 * @author yh
 * @date 2019/01/08
 */
public class DeviceInfoActivity extends AppCompatActivity {

    private TextView tvShowDeviceInfo;


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
        tvShowDeviceInfo = findViewById(R.id.tv_show_device_info);
    }

    private void initData() {
        String deviceInfo = "";
        deviceInfo = deviceInfo + "手机厂商：" + ManufacturerInfoUtils.getCurrentDeviceManufacturer();
        tvShowDeviceInfo.setText(deviceInfo);
    }
}

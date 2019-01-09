package com.yh.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yh.utils.adapter.MainListAdapter;

import java.util.ArrayList;

/**
 * 主Demo列表界面
 *
 * @author yh
 * @date 2019/01/08
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private MainListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListen();
    }

    private void initView() {
        rvMain = findViewById(R.id.rv_main);
    }

    private void initData() {
        ArrayList<String> mData = new ArrayList<>();
        mData.add("设备信息");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMain.setLayoutManager(layoutManager);
        adapter = new MainListAdapter(this, mData);
        rvMain.setAdapter(adapter);
    }

    private void initListen() {
        adapter.setOnItemClick(new MainListAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        //设备信息
                        DeviceInfoActivity.openSelf(MainActivity.this);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}

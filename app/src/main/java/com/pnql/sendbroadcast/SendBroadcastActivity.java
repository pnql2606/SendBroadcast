package com.pnql.sendbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public class SendBroadcastActivity extends AppCompatActivity {

    private static final Object R = ;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.attr.layout.activity_send_broadcast);
        configureReceiver();
    }

    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.pnql.sendbroadcast");

        //cho phép intent bắt đầu một thành phần
        //của ứng dụng trong trạng thái dừng

        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    private void configureReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.pnql.sendbroadcast");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        receiver = new MyReceiver();
        registerReceiver(receiver, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }




}
package com.example.bckj.tuluoyi.m;

import android.util.Log;

import com.example.bckj.tuluoyi.net.SetCreate;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/25.
 */

public class MoudelLayer {
    public Retrofit getData() {
        Log.d("zzz", "getFirst_hand_HostData");
        return SetCreate.setCreate();
    }
}

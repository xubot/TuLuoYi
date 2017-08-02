package com.example.bckj.tuluoyi.p;

import android.util.Log;

import com.example.bckj.tuluoyi.Bean.AttractionsBean;
import com.example.bckj.tuluoyi.View.ActivityView;
import com.example.bckj.tuluoyi.m.MoudelLayer;
import com.example.bckj.tuluoyi.net.Api;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/25.
 */

public class PresenterLayer {

    private final MoudelLayer moudelLayer;
    private ActivityView activityView;

    //P层构造器
    public PresenterLayer() {
        moudelLayer = new MoudelLayer();
    }
    //得到View对象
    public void setViewLayer(ActivityView activityView) {
        this.activityView = activityView;
    }
    //发起请求
    public void getCity(double latitude, double longitude) {
        Retrofit retrofit = moudelLayer.getData();
        Api api = retrofit.create(Api.class);
        Observable<AttractionsBean> List_course = api.getCities(latitude+"",longitude+"");
        List_course.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttractionsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttractionsBean attractionsBean) {
                        Log.d("zzz", attractionsBean + "vddddddddd");
                        activityView.attractions(attractionsBean);
                        Log.d("zzz", "2");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}



package com.example.bckj.tuluoyi.net;

import com.example.bckj.tuluoyi.Bean.AttractionsBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by liuhao
 * on 2017/4/11
 * use to :
 */

public interface Api {
    @GET("sc/index.php?s=/home/scenic/index/lat/lng")
    Observable<AttractionsBean> getCities(@Query("lat") String lat, @Query("lng")String lng);


    @POST("")
    @FormUrlEncoded
    Observable<String> getData();
}

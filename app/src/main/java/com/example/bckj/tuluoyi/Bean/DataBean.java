package com.example.bckj.tuluoyi.Bean;

/**
 * Created by Administrator on 2017/8/2.
 */

public class DataBean {
    private String name;
    private String address;
    //距离
    private double distance;
    //评分
    private String overall_rating;
    //详情信息
    private String detail_url;

    public String getDetail_url() {
        return detail_url;
    }

    public void setDetail_url(String detail_url) {
        this.detail_url = detail_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(String overall_rating) {
        this.overall_rating = overall_rating;
    }
    public DataBean(String name, String address, double distance, String overall_rating, String detail_url) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.overall_rating = overall_rating;
        this.detail_url = detail_url;

    }
}

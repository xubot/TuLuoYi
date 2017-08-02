package com.example.bckj.tuluoyi.Bean;

/**
 * Created by Administrator on 2017/8/2.
 */

public class EngDataBean {
    private String name_en;
    private String address_en;
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

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;

    }

    public String getAddress_en() {
        return address_en;
    }

    public void setAddress_en(String address_en) {
        this.address_en = address_en;
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

    public EngDataBean(String name_en, String address_en, double distance, String overall_rating,String detail_url) {
        this.name_en = name_en;
        this.address_en = address_en;
        this.distance = distance;
        this.overall_rating = overall_rating;
        this.detail_url = detail_url;
    }
}

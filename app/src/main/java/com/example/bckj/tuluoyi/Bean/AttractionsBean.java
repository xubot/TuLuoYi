package com.example.bckj.tuluoyi.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */

public class AttractionsBean {

    /**
     * code : 1
     * data : {"list":[{"address":"北京市海淀区颐和园路5号北京大学","address_en":"No. 5, the Summer Palace Road, Beijing, Haidian District, Peking University","comment_num":"47","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=4fc3161a6b605caa3a13fd2c&output=html&source=placeapi_v2","distance":0.621,"id":"172","image_num":"31","lat":"40.000661","lng":"116.316705","name":"未名湖","name_en":"Weiminghu Lake","navi_lat":"","navi_lng":"","overall_rating":"4.4","price":"","street_id":"4fc3161a6b605caa3a13fd2c","tag":"旅游景点;风景区","telephone":"","type":"1","uid":"4fc3161a6b605caa3a13fd2c"},{"address":"北京市海淀区中关村彩和坊9号","address_en":"Beijing City, Haidian District Zhongguancun square No. 9","comment_num":"185","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=57dcde056c836e330482c2ca&output=html&source=placeapi_v2","distance":0.858,"id":"279","image_num":"14","lat":"39.989073","lng":"116.314029","name":"基督教堂","name_en":"Christ Church","navi_lat":"39.989197118559","navi_lng":"116.31459452853","overall_rating":"4.3","price":"","street_id":"57dcde056c836e330482c2ca","tag":"旅游景点;教堂","telephone":"010-82613772","type":"1","uid":"57dcde056c836e330482c2ca"},{"address":"新建宫门路2号","address_en":"No. 2 New Palace Road","comment_num":"446","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=92df8c20d3c448cf52e5c5f5&output=html&source=placeapi_v2","distance":1.545,"id":"136","image_num":"154","lat":"39.993222","lng":"116.301669","name":"海淀公园","name_en":"haidian park","navi_lat":"39.994127358518","navi_lng":"116.30585759746","overall_rating":"4.5","price":"","street_id":"92df8c20d3c448cf52e5c5f5","tag":"旅游景点;公园","telephone":"","type":"1","uid":"92df8c20d3c448cf52e5c5f5"},{"address":"北京市海淀区清华路","address_en":"Qinghua Road, Haidian District, Beijing","comment_num":"39","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=844a750e925cf1b9636858ab&output=html&source=placeapi_v2","distance":1.594,"id":"95","image_num":"40","lat":"40.006851","lng":"116.330962","name":"清华园","name_en":"Tsinghua Yuan","navi_lat":"40.006645872477","navi_lng":"116.33105734332","overall_rating":"4.6","price":"","street_id":"844a750e925cf1b9636858ab","tag":"旅游景点;风景区","telephone":"","type":"1","uid":"844a750e925cf1b9636858ab"},{"address":"北京市海淀区清华园","address_en":"Tsinghua Yuan, Haidian District, Beijing","comment_num":"25","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=438bf3665c841a7b4d554788&output=html&source=placeapi_v2","distance":1.719,"id":"200","image_num":"26","lat":"40.008934","lng":"116.329538","name":"水木清华","name_en":"Smth","navi_lat":"","navi_lng":"","overall_rating":"4.4","price":"","street_id":"438bf3665c841a7b4d554788","tag":"旅游景点;风景区","telephone":"(010)62793001","type":"1","uid":"438bf3665c841a7b4d554788"},{"address":"北京市海淀区荷清路","address_en":"Hollywood Road, Beijing, Haidian District","comment_num":"52","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=98b68e6b8b3944e00c0a7007&output=html&source=placeapi_v2","distance":2.348,"id":"266","image_num":"3","lat":"40.007591","lng":"116.342117","name":"清华大学-艺术博物馆","name_en":"Tsinghua University - Art Museum","navi_lat":"40.007900986842","navi_lng":"116.34106611509","overall_rating":"4.3","price":"","street_id":"98b68e6b8b3944e00c0a7007","tag":"旅游景点;博物馆","telephone":"","type":"1","uid":"98b68e6b8b3944e00c0a7007"}],"total":"6"}
     * msg : 成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * list : [{"address":"北京市海淀区颐和园路5号北京大学","address_en":"No. 5, the Summer Palace Road, Beijing, Haidian District, Peking University","comment_num":"47","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=4fc3161a6b605caa3a13fd2c&output=html&source=placeapi_v2","distance":0.621,"id":"172","image_num":"31","lat":"40.000661","lng":"116.316705","name":"未名湖","name_en":"Weiminghu Lake","navi_lat":"","navi_lng":"","overall_rating":"4.4","price":"","street_id":"4fc3161a6b605caa3a13fd2c","tag":"旅游景点;风景区","telephone":"","type":"1","uid":"4fc3161a6b605caa3a13fd2c"},{"address":"北京市海淀区中关村彩和坊9号","address_en":"Beijing City, Haidian District Zhongguancun square No. 9","comment_num":"185","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=57dcde056c836e330482c2ca&output=html&source=placeapi_v2","distance":0.858,"id":"279","image_num":"14","lat":"39.989073","lng":"116.314029","name":"基督教堂","name_en":"Christ Church","navi_lat":"39.989197118559","navi_lng":"116.31459452853","overall_rating":"4.3","price":"","street_id":"57dcde056c836e330482c2ca","tag":"旅游景点;教堂","telephone":"010-82613772","type":"1","uid":"57dcde056c836e330482c2ca"},{"address":"新建宫门路2号","address_en":"No. 2 New Palace Road","comment_num":"446","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=92df8c20d3c448cf52e5c5f5&output=html&source=placeapi_v2","distance":1.545,"id":"136","image_num":"154","lat":"39.993222","lng":"116.301669","name":"海淀公园","name_en":"haidian park","navi_lat":"39.994127358518","navi_lng":"116.30585759746","overall_rating":"4.5","price":"","street_id":"92df8c20d3c448cf52e5c5f5","tag":"旅游景点;公园","telephone":"","type":"1","uid":"92df8c20d3c448cf52e5c5f5"},{"address":"北京市海淀区清华路","address_en":"Qinghua Road, Haidian District, Beijing","comment_num":"39","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=844a750e925cf1b9636858ab&output=html&source=placeapi_v2","distance":1.594,"id":"95","image_num":"40","lat":"40.006851","lng":"116.330962","name":"清华园","name_en":"Tsinghua Yuan","navi_lat":"40.006645872477","navi_lng":"116.33105734332","overall_rating":"4.6","price":"","street_id":"844a750e925cf1b9636858ab","tag":"旅游景点;风景区","telephone":"","type":"1","uid":"844a750e925cf1b9636858ab"},{"address":"北京市海淀区清华园","address_en":"Tsinghua Yuan, Haidian District, Beijing","comment_num":"25","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=438bf3665c841a7b4d554788&output=html&source=placeapi_v2","distance":1.719,"id":"200","image_num":"26","lat":"40.008934","lng":"116.329538","name":"水木清华","name_en":"Smth","navi_lat":"","navi_lng":"","overall_rating":"4.4","price":"","street_id":"438bf3665c841a7b4d554788","tag":"旅游景点;风景区","telephone":"(010)62793001","type":"1","uid":"438bf3665c841a7b4d554788"},{"address":"北京市海淀区荷清路","address_en":"Hollywood Road, Beijing, Haidian District","comment_num":"52","detail":"1","detail_url":"http://api.map.baidu.com/place/detail?uid=98b68e6b8b3944e00c0a7007&output=html&source=placeapi_v2","distance":2.348,"id":"266","image_num":"3","lat":"40.007591","lng":"116.342117","name":"清华大学-艺术博物馆","name_en":"Tsinghua University - Art Museum","navi_lat":"40.007900986842","navi_lng":"116.34106611509","overall_rating":"4.3","price":"","street_id":"98b68e6b8b3944e00c0a7007","tag":"旅游景点;博物馆","telephone":"","type":"1","uid":"98b68e6b8b3944e00c0a7007"}]
         * total : 6
         */

        private String total;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * address : 北京市海淀区颐和园路5号北京大学
             * address_en : No. 5, the Summer Palace Road, Beijing, Haidian District, Peking University
             * comment_num : 47
             * detail : 1
             * detail_url : http://api.map.baidu.com/place/detail?uid=4fc3161a6b605caa3a13fd2c&output=html&source=placeapi_v2
             * distance : 0.621
             * id : 172
             * image_num : 31
             * lat : 40.000661
             * lng : 116.316705
             * name : 未名湖
             * name_en : Weiminghu Lake
             * navi_lat :
             * navi_lng :
             * overall_rating : 4.4
             * price :
             * street_id : 4fc3161a6b605caa3a13fd2c
             * tag : 旅游景点;风景区
             * telephone :
             * type : 1
             * uid : 4fc3161a6b605caa3a13fd2c
             */

            private String address;
            private String address_en;
            private String comment_num;
            private String detail;
            private String detail_url;
            private double distance;
            private String id;
            private String image_num;
            private String lat;
            private String lng;
            private String name;
            private String name_en;
            private String navi_lat;
            private String navi_lng;
            private String overall_rating;
            private String price;
            private String street_id;
            private String tag;
            private String telephone;
            private String type;
            private String uid;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddress_en() {
                return address_en;
            }

            public void setAddress_en(String address_en) {
                this.address_en = address_en;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getDetail_url() {
                return detail_url;
            }

            public void setDetail_url(String detail_url) {
                this.detail_url = detail_url;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage_num() {
                return image_num;
            }

            public void setImage_num(String image_num) {
                this.image_num = image_num;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getNavi_lat() {
                return navi_lat;
            }

            public void setNavi_lat(String navi_lat) {
                this.navi_lat = navi_lat;
            }

            public String getNavi_lng() {
                return navi_lng;
            }

            public void setNavi_lng(String navi_lng) {
                this.navi_lng = navi_lng;
            }

            public String getOverall_rating() {
                return overall_rating;
            }

            public void setOverall_rating(String overall_rating) {
                this.overall_rating = overall_rating;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getStreet_id() {
                return street_id;
            }

            public void setStreet_id(String street_id) {
                this.street_id = street_id;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }
    }
}

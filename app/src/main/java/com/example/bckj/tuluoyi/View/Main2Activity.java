package com.example.bckj.tuluoyi.View;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.example.bckj.tuluoyi.Bean.AttractionsBean;
import com.example.bckj.tuluoyi.Bean.DataBean;
import com.example.bckj.tuluoyi.Bean.EngDataBean;
import com.example.bckj.tuluoyi.R;
import com.example.bckj.tuluoyi.ShowActivity;
import com.example.bckj.tuluoyi.p.PresenterLayer;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,ActivityView{
    private SensorManager manager;
    private SensorListener listener = new SensorListener();
    private RelativeLayout rl;
    private List<TextView> tvList=new ArrayList<>();
    //中文数据集合
    private List<DataBean> dataBeanList=new ArrayList<>();
    //英文数据集合
    private List<EngDataBean> engDataBeanList=new ArrayList<>();
    private PopupWindow popupWindow;
    private View view;
    private boolean flag=true;
    private double latitude;
    private double longitude;

    //定位的参数
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private DataBean dataBean;
    private EngDataBean engDataBean;
    private TextView spotName;
    private TextView size;
    private TextView address;
    private TextView detail;
    private String lang;
    private TextView language;
    private PopupWindow window;
    private EditText origin;
    private EditText destination;
    private List<Poi> list;
    private View inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //得到设置陀螺仪的控件
        rl = (RelativeLayout) this.findViewById(R.id.rl);
        //得到语言控件
        language = (TextView) findViewById(R.id.language);
        //切换点击事件
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到textView的值
                lang = language.getText().toString();
                setChenk1(lang);
            }
        });

        //开启定位
        startLocation();
        //设置信息pop
        setPop();
        //设置打车的弹出框
        setCarPop();
        //设置屏幕高亮
        rl.setKeepScreenOn(true);
        // 取得传感器管理器对象
        manager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
    }
    //开启定位
    private void startLocation() {
        //初始化定位对象  声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener(myListener);
        initLocation();
        mLocationClient.start();
    }

    //设置参数
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps
        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    //当前位置的信息类
    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //得到经度值
            latitude = location.getLatitude();
            //得到纬度值
            longitude = location.getLongitude();
            //得到地址
            String addrStr = location.getAddrStr();
            Log.d("zzz", latitude + "==" + longitude+"=="+addrStr);
            //得到Poi数据
            list = location.getPoiList();
            if (list != null) {
                for (Poi p : list) {
                    String id = p.getId();
                    String name = p.getName();
                    double rank = p.getRank();
                    Log.d("zzz",id+"=="+name+""+rank);
                }
            }
            origin.setText(list.get(2).getName());

            load();
        }
        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    //设置景点信息的popupWindow
    private void setPop() {
        //找到视图,作为popupWindow显示的视图
        view = View.inflate(this, R.layout.popview, null);
        //景点名字
        spotName = (TextView) view.findViewById(R.id.spotName);
        //距离
        size = (TextView) view.findViewById(R.id.size);
        //地址
        address = (TextView) view.findViewById(R.id.address);
        detail = (TextView) view.findViewById(R.id.detail);
        //得到popupWindow,设置popupWindow显示的内容和宽高
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.WRAP_CONTENT);
        //设置popupWindow的背景,当前设置的是透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置点击popupWindow外部,是否可以消失,如果想要消失,必须通过setBackgroundDrawable方法设置popupWindow的背景
        popupWindow.setOutsideTouchable(true);
    }

    //设置打车的popupWindow
    private void setCarPop() {
        //找到视图,作为popupWindow显示的视图
        inflate = View.inflate(this, R.layout.carpopview, null);
        //输入起点位置
        origin = (EditText) inflate.findViewById(R.id.origin);
        //输入终点位置
        destination = (EditText) inflate.findViewById(R.id.destination);
        //得到popupWindow,设置popupWindow显示的内容和宽高
        window = new PopupWindow(inflate, WindowManager.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //设置popupWindow的背景,当前设置的是透明
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置点击popupWindow外部,是否可以消失,如果想要消失,必须通过setBackgroundDrawable方法设置popupWindow的背景
        window.setFocusable(true);
        window.setOutsideTouchable(false);
    }

    //设置点击监听
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.centrality:
                window.showAtLocation(inflate,Gravity.BOTTOM,0, 0);
                break;
            case R.id.one:
                String oneLg = language.getText().toString();
                //setAnimation();
                popupWindow.showAtLocation(view,Gravity.BOTTOM,0, 0);
                if(oneLg.equals("中文")){
                    popData(0);
                }else if(oneLg.equals("English")){
                    engPopData(0);
                }
                break;
            case R.id.twe:
                String tweLg = language.getText().toString();
                //setAnimation();
                popupWindow.showAtLocation(view, Gravity.BOTTOM,0, 0);
                if(tweLg.equals("中文")){
                    popData(1);
                }else if(tweLg.equals("English")){
                    engPopData(1);
                }
                break;
            case R.id.three:
                String threeLg = language.getText().toString();
                //setAnimation();
                popupWindow.showAtLocation(view, Gravity.BOTTOM,0, 0);
                if(threeLg.equals("中文")){
                    popData(2);
                }else if(threeLg.equals("English")){
                    engPopData(2);
                }
                break;
        }
    }
    //点击弹出的景点信息
    private void popData(final int num) {
        spotName.setText("景点名： "+dataBeanList.get(num).getName());
        size.setText("距离： "+dataBeanList.get(num).getDistance()+"");
        address.setText("地址： "+dataBeanList.get(num).getAddress());
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, ShowActivity.class);
                String detail_url = dataBeanList.get(num).getDetail_url();
                intent.putExtra("url", detail_url);
                startActivity(intent);
            }
        });
    }
    //点击弹出的英文景点信息
    private void engPopData(final int num) {
        spotName.setText("景点名： "+engDataBeanList.get(num).getName_en());
        size.setText("距离： "+dataBeanList.get(num).getDistance()+"");
        address.setText("地址： "+engDataBeanList.get(num).getAddress_en());
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, ShowActivity.class);
                String detail_url = dataBeanList.get(num).getDetail_url();
                intent.putExtra("url", detail_url);
                startActivity(intent);
            }
        });
    }

    //点击后向上平移动画
    private void setAnimation() {
        if(flag){
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
            set.addAnimation(translate);
            set.setFillAfter(true);
            rl.offsetTopAndBottom(-rl.getHeight() /6);
            rl.startAnimation(set);
            //设置动画持续时间
            translate.setDuration(200);
            flag=false;
        }
    }

    //得到点击控件
    private void setChenk() {
        TextView one= (TextView) findViewById(R.id.one);
        TextView twe= (TextView) findViewById(R.id.twe);
        TextView three= (TextView) findViewById(R.id.three);
        ImageView centr= (ImageView) findViewById(R.id.centrality);
        one.setText(dataBeanList.get(0).getName()+"\n"+dataBeanList.get(0).getOverall_rating()+"分");
        twe.setText(dataBeanList.get(1).getName()+"\n"+dataBeanList.get(1).getOverall_rating()+"分");
        three.setText(dataBeanList.get(2).getName()+"\n"+dataBeanList.get(2).getOverall_rating()+"分");
        tvList.add(one);
        tvList.add(twe);
        tvList.add(three);
        centr.setOnClickListener(this);
        for (TextView tvl:tvList){
            tvl.setOnClickListener(this);
        }
    }

    //得到切换点击控件(切换模式)
    private void setChenk1(String lang) {
        TextView one= (TextView) findViewById(R.id.one);
        TextView twe= (TextView) findViewById(R.id.twe);
        TextView three= (TextView) findViewById(R.id.three);
        if(lang.equals("English")){
            one.setText(dataBeanList.get(0).getName()+"\n"+dataBeanList.get(0).getOverall_rating()+"分");
            twe.setText(dataBeanList.get(1).getName()+"\n"+dataBeanList.get(1).getOverall_rating()+"分");
            three.setText(dataBeanList.get(2).getName()+"\n"+dataBeanList.get(2).getOverall_rating()+"分");
            language.setText("中文");
        }else if(lang.equals("中文")){
            one.setText(engDataBeanList.get(0).getName_en()+"\n"+dataBeanList.get(0).getOverall_rating()+"分");
            twe.setText(engDataBeanList.get(1).getName_en()+"\n"+dataBeanList.get(1).getOverall_rating()+"分");
            three.setText(engDataBeanList.get(2).getName_en()+"\n"+dataBeanList.get(2).getOverall_rating()+"分");
            language.setText("English");
        }
        tvList.add(one);
        tvList.add(twe);
        tvList.add(three);
        for (TextView tvl:tvList){
            tvl.setOnClickListener(this);
        }
    }

    //界面随摇动而变化
    private final class SensorListener implements SensorEventListener {
        // 定义一个变量来记录之前的角度
        private float predegree = 0;
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
        //传感器变化的方法
        public void onSensorChanged(SensorEvent event) {
            // 得到传感器测量出来的数据
            float degree = event.values[0];
            //定义动画效果
            RotateAnimation animation = new RotateAnimation(predegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            //设置动画持续时间
            animation.setDuration(200);
            //添加动画
            rl.startAnimation(animation);
            //保证画面不会抖动
            predegree=-degree;
        }
    }

    //重启的生命周期
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        // 方向传感器
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        // 监听传感器
        manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_GAME);
        super.onResume();
    }

    //暂停的生命周期
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        //取消注册免得耗电
        manager.unregisterListener(listener);
        super.onPause();
    }

    //得到P层数据的方法
    public void load() {
        PresenterLayer presenterLayer = new PresenterLayer();
        presenterLayer.setViewLayer(this);
        presenterLayer.getCity(latitude,longitude);
        Log.d("zzz", "3" + latitude + "==" + longitude);
    }
    //得到请求的数据
    @Override
    public void attractions(AttractionsBean attractionsBean) {
        Log.d("zzz", "4");
        List<AttractionsBean.DataBean.ListBean> attractionsList = attractionsBean.getData().getList();
        for(AttractionsBean.DataBean.ListBean al:attractionsList){
            String address = al.getAddress();
            String address_en = al.getAddress_en();
            String name = al.getName();
            String name_en = al.getName_en();
            double distance = al.getDistance();
            String overall_rating = al.getOverall_rating();
            String detail_url = al.getDetail_url();
            //中文景点信息
            dataBean = new DataBean(name, address, distance, overall_rating,detail_url);
            //英文景点信息
            engDataBean = new EngDataBean(name_en, address_en, distance, overall_rating,detail_url);
            dataBeanList.add(dataBean);
            String overall_rating1 = dataBeanList.get(0).getOverall_rating();
            engDataBeanList.add(engDataBean);
            Log.d("zzz", "5"+"=="+dataBeanList.size()+""+"==="+overall_rating1);
        }
        //景点的点击
        setChenk();
    }
}

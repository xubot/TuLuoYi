package com.example.bckj.tuluoyi;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private SensorManager manager;
    private SensorListener listener = new SensorListener();
    private RelativeLayout rl;
    private List<TextView> tvList=new ArrayList<>();
    private PopupWindow popupWindow;
    private View view;
    private boolean flag=true;


    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rl = (RelativeLayout) this.findViewById(R.id.rl);
        startLocation();
        setPop();
        setChenk();
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
        int span = 1000;
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
            //获取定位结果
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息
            double latitude = location.getLatitude();
            Log.d("zzz", latitude + "==" + location.getLongitude()+location.getCity());

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation){

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            final List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    //设置popupWindow
    private void setPop() {
        //找到视图,作为popupWindow显示的视图
        view = View.inflate(this, R.layout.popview, null);
        //得到popupWindow,设置popupWindow显示的内容和宽高
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 300);
        //设置popupWindow的背景,当前设置的是透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置点击popupWindow外部,是否可以消失,如果想要消失,必须通过setBackgroundDrawable方法设置popupWindow的背景
        popupWindow.setOutsideTouchable(false);
    }

    //点击后向上平移动画
    private void setAnimation() {
        if(flag){
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
            set.addAnimation(translate);
            set.setFillAfter(true);
            rl.offsetTopAndBottom(-rl.getHeight() /5);
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
        tvList.add(one);
        tvList.add(twe);
        tvList.add(three);
        for (TextView tvl:tvList){
            tvl.setOnClickListener(this);
        }
    }

    //设置点击监听
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.one:
                setAnimation();
                popupWindow.showAtLocation(v, Gravity.BOTTOM,0, 0);
                break;
            case R.id.twe:
                setAnimation();
                popupWindow.showAtLocation(v, Gravity.BOTTOM,0, 0);
                break;
            case R.id.three:
                setAnimation();
                popupWindow.showAtLocation(v, Gravity.BOTTOM,0, 0);
                break;
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

}

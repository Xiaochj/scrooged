package com.scrooged.past.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.scrooged.past.ScroogedApplication;
import com.scrooged.past.model.BaseWeahterBean;
import com.scrooged.past.net.AppEngine;
import java.text.SimpleDateFormat;
import java.util.Date;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaochj on 2017/6/1.
 */

public class MainActivity extends Activity implements AMapLocationListener {

  //声明AMapLocationClient类对象
  public AMapLocationClient mLocationClient = null;
  //声明AMapLocationClientOption对象
  public AMapLocationClientOption mLocationOption = null;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initLoc();
  }

  //定位
  private void initLoc() {
    //初始化定位
    mLocationClient = new AMapLocationClient(getApplicationContext());
    //设置定位回调监听
    mLocationClient.setLocationListener(this);
    //初始化定位参数
    mLocationOption = new AMapLocationClientOption();
    //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    //设置是否返回地址信息（默认返回地址信息）
    mLocationOption.setNeedAddress(true);
    //设置是否只定位一次,默认为false
    mLocationOption.setOnceLocation(true);
    //设置是否强制刷新WIFI，默认为强制刷新
    mLocationOption.setWifiActiveScan(true);
    //设置是否允许模拟位置,默认为false，不允许模拟位置
    mLocationOption.setMockEnable(false);
    //设置定位间隔,单位毫秒,默认为2000ms
    //mLocationOption.setInterval(2000);
    //给定位客户端对象设置定位参数
    mLocationClient.setLocationOption(mLocationOption);
    //启动定位
    mLocationClient.startLocation();
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override protected void onRestart() {
    super.onRestart();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @Override public void onLocationChanged(AMapLocation amapLocation) {
    if (amapLocation != null) {
      if (amapLocation.getErrorCode() == 0) {
        //定位成功回调信息，设置相关消息
        amapLocation.getLatitude();//获取纬度
        amapLocation.getLongitude();//获取经度
        AppEngine.getWeatherInstance().getAppService().getWeatherNow(amapLocation.getLatitude()+","+amapLocation.getLongitude(),
            ScroogedApplication.YYWeahterKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BaseWeahterBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            Log.e("error","err");
          }

          @Override public void onNext(BaseWeahterBean baseWeahterBean) {
            if(baseWeahterBean.code == 1){
              if(baseWeahterBean.data != null){
                Toast.makeText(MainActivity.this,baseWeahterBean.data.fl,Toast.LENGTH_LONG).show();
              }
            }
          }
        });
      } else {
        //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
        Log.e("AmapError", "location Error, ErrCode:"
            + amapLocation.getErrorCode()
            + ", errInfo:"
            + amapLocation.getErrorInfo());

        Toast.makeText(getApplicationContext(), "定位失败", Toast.LENGTH_LONG).show();
      }
    }
  }
}

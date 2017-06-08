package com.scrooged.past;

import android.app.Application;
import com.scrooged.past.net.AppEngine;

/**
 * Created by xiaochj on 2017/6/8.
 */

public class ScroogedApplication extends Application {

  public static final String YYWeahterKey = "rvico3a6gulbcmpd ";

  @Override public void onCreate() {
    super.onCreate();
    AppEngine.init(this);
    AppEngine.initWeather(this);
  }
}

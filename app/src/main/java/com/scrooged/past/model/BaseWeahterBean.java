package com.scrooged.past.model;

/**
 * Created by xiaochj on 2017/6/8.
 */

public class BaseWeahterBean {

  //code = 1 成功 code = 0 失败
  public int code;
  //Success ／ Error
  public String msg;
  //剩余API调用次数
  public int counts;
  //天气数据
  public WeatherData data;
  //错误分析
  public String directions;
}

package com.scrooged.past.model;

/**
 * Created by xiaochj on 2017/6/8.
 */

public class WeatherData {
  /**
   * "cityId": "CH010100",  //城市id
   * "cityName": "北京",  //城市名称
   * "lastUpdate": "2016-03-09 17:10:00",  //实况更新时间
   * "tq": "多云",  //天气现象
   * "numtq": "01",  //天气现象编码
   * "qw": "5.0",  //当前气温
   * "fl": "微风",  //当前风力
   * "numfl": "0",  //当前风力编码
   * "fx": "无持续风向",  //当前风向
   * "numfx": "0",  //当前风向编码
   * "sd": "10.0"  //相对湿度，直接在此数值后添加%即可
   */

  public String cityId;
  public String cityName;
  public String lastUpdate;
  public String tq;
  public String numtq;
  public String qw;
  public String fl;
  public String fx;
  public String numfx;
  public String sd;
}

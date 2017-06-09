package com.scrooged.past.utils;

/**
 * 火星坐标和百度坐标转换工具（火星坐标是高德地图实用的）
 * Created by xiaochj on 2017/6/9.
 */

public class MapGeoCodeUtil {

  static final double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

  /**
   * 火星坐标转换为百度坐标
   */
  public static double[] bd_encrypt(double hx_lat, double hx_lon) {
    double[] bd_latlngs = { 0, 0 };
    double x = hx_lon, y = hx_lat;
    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
    bd_latlngs[1] = z * Math.cos(theta) + 0.0065;//lng
    bd_latlngs[0] = z * Math.sin(theta) + 0.006;//lat
    return bd_latlngs;
  }

  /**
   * 百度坐标转换为火星坐标
   */
  public static double[] bd_decrypt(double bd_lat, double bd_lon) {
    double[] gg_latlngs = { 0, 0 };
    double x = bd_lon - 0.0065, y = bd_lat - 0.006;
    double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
    double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
    gg_latlngs[1] = z * Math.cos(theta);//lng
    gg_latlngs[0] = z * Math.sin(theta);//lat
    return gg_latlngs;
  }
}

package com.scrooged.past.utils;

import java.util.Date;

/**
 * 获取系统日期时间的工具类
 * Created by xiaochj on 2017/6/1.
 */

public class DatetimeUtil {

  private static final long minute = 60 * 1000;//1分钟
  private static final long hour = 60 * minute;//1小时
  private static final long day = 24 * hour;//1天
  private static final long month = 31 * day;//月
  private static final long year = 12 * month;//年

  /**
   * 返回文字描述的日期
   */
  public static String getTimeFormatText(Date date) {
    if (date == null) return null;
    long diff = new Date().getTime() - date.getTime();
    long r = 0;
    if (diff > year) {
      r = diff / year;
      return r + "年前";
    }
    if (diff > month) {
      r = diff / month;
      return r + "个月前";
    }
    if (diff > day) {
      r = diff / day;
      return r + "天前";
    }
    if (diff > hour) {
      r = diff / hour;
      return r + "个小时前";
    }
    if (diff > minute) {
      r = diff / minute;
      return r + "分钟前";
    }
    return "刚刚";
  }
}




















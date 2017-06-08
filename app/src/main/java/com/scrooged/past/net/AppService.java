package com.scrooged.past.net;

import com.scrooged.past.model.BaseWeahterBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 服务器接口
 * Created by xiaochj on 17/3/27.
 */
public interface AppService {

  /**
   * 获取实时天气预报
   */
  @GET("observe") Observable<BaseWeahterBean> getWeatherNow(
      @Query("city") String city,@Query("key") String key);
}

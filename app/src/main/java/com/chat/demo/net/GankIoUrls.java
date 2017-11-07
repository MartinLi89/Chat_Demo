package com.chat.demo.net;

import com.chat.demo.entity.FuLiUrlResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author ex-lisuyang001
 * @date 2017/11/6
 * <p>
 * 网络请求接口
 * <p>
 * base util=http://gank.io/api
 * /data/福利/10/1
 */

public interface GankIoUrls {
	String BATH_URL = "http://gank.io/api/";


	@GET("data/福利/{month}/{day}")
	Call<FuLiUrlResults> dataFuLi(@Path("month") String month, @Path("day") String day);


}

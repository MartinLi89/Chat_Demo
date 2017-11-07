package com.chat.demo.net;


import com.chat.demo.entity.FuLiUrlResults;
import com.chat.demo.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ex-lisuyang001
 * @date 2017/11/6
 * 网络请求库
 */

public class RetrofitClient {


	private final GankIoUrls gankIoUrls;
	private static RetrofitClient retrofitClient;


	private RetrofitClient() {
		gankIoUrls = new Retrofit.Builder()
				.baseUrl(GankIoUrls.BATH_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(GankIoUrls.class);
		

	}


	public static RetrofitClient get() {
		if (retrofitClient == null) {
			synchronized (RetrofitClient.class) {
				if (retrofitClient == null) {
					retrofitClient = new RetrofitClient();
					return retrofitClient;
				}

			}
		}

		return retrofitClient;

	}


	public void getFuli(String month, String day) {

		Call<FuLiUrlResults> stringCall = gankIoUrls.dataFuLi(month, day);
		stringCall.enqueue(new Callback<FuLiUrlResults>() {
			@Override
			public void onResponse(Call<FuLiUrlResults> call, Response<FuLiUrlResults> response) {

				EventBus.getDefault().post(response.body().getResults());


			}

			@Override
			public void onFailure(Call<FuLiUrlResults> call, Throwable t) {
				LogUtil.infor(t.getMessage());
			}
		});
	}



}

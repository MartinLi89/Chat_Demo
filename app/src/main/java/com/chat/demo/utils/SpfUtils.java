package com.chat.demo.utils;

import android.content.Context;

/**
 * @author ex-lisuyang001
 * @date 2017/11/6
 * 用于本地缓存的类
 */

public class SpfUtils {
	private static final String NAME = "lsys";


	/**
	 * 保存String
	 *
	 * @param ctx
	 * @param key
	 * @param value
	 */
	public static void setStringValue(Context ctx, String key, String value) {
//        SharedPreferences spf = null;
		if (null == ctx || null == key || null == value) {
			new Throwable("参数不可为空");
		}
		ctx.getSharedPreferences(NAME, Context.MODE_PRIVATE)
				.edit()
				.putString(key, value)
				.apply();

	}

	/**
	 * 获得String
	 *
	 * @param ctx
	 * @param key
	 * @return
	 */
	public static String getStringValue(Context ctx, String key) {
		if (null == ctx || null == key) {
			new Throwable("参数不可为空");
		}
		return ctx.getSharedPreferences(NAME,
				Context.MODE_PRIVATE).getString(key, "");
	}
}

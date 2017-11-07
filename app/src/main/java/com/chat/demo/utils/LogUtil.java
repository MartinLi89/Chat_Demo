package com.chat.demo.utils;

import android.util.Log;

/**
 * @author ex-lisuyang001
 * @date 2017/11/6
 */

public class LogUtil {

	private static String TAG = "LogUtil";

	public static void infor(String msg) {
		infor(TAG, msg);
	}

	public static void infor(String tag, String msg) {
		Log.i(tag, msg);
	}


	public static void debug(String msg) {
		debug(TAG, msg);
	}
	public static void debug(String tag, String msg) {
		Log.i(tag, msg);
	}

	public static void error(String msg) {
		error(TAG, msg);
	}
	public static void error(String tag, String msg) {
		Log.i(tag, msg);
	}

	public static void warn(String msg) {
		warn(TAG, msg);
	}
	public static void warn(String tag, String msg) {
		Log.i(tag, msg);
	}
}

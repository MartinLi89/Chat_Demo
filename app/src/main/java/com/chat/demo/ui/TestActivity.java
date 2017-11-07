package com.chat.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chat.demo.R;

import org.greenrobot.eventbus.EventBus;

/**
 * @author ex-lisuyang001
 */
public class TestActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		String json = "";
		EventBus.getDefault().post(json);
	}
}

package com.chat.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chat.demo.R;
import com.chat.demo.entity.FuLiBean;
import com.chat.demo.net.RetrofitClient;
import com.chat.demo.utils.LogUtil;
import com.chat.demo.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author ex-lisuyang001
 */
public class MainActivity extends AppCompatActivity {

	@BindView(R.id.showToast)
	Button showToast;
	@BindView(R.id.iv_show_jpeg)
	ImageView ivShowJpeg;

	private Unbinder bind;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bind = ButterKnife.bind(this);


		EventBus.getDefault().register(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEventCome(String json) {
		LogUtil.infor(json);
		ToastUtil.showToast(MainActivity.this, json);

		Glide.with(MainActivity.this)
				.load(json)
				.into(ivShowJpeg);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEventFuli(List<FuLiBean> list) {
		String urls = list != null && list.size() > 0 ? list.get(0).getUrl() : "没有获得";
		ToastUtil.showToast(MainActivity.this, urls);
		Glide.with(MainActivity.this)
				.load(urls)
				.into(ivShowJpeg);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
		if (bind != null) {
			bind.unbind();
			bind = null;
		}
	}

	@OnClick(R.id.showToast)
	public void onViewClicked() {

		RetrofitClient.get().getFuli("10", "1");

	}
}

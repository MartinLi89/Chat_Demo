package com.chat.demo.entity;

import java.util.List;

/**
 * @author ex-lisuyang001
 * @date 2017/11/6
 */

public class FuLiUrlResults extends BaseBean {

	public List<FuLiBean> results;

	public List<FuLiBean> getResults() {
		return results;
	}

	public void setList(List<FuLiBean> resultss) {
		this.results = resultss;
	}
}

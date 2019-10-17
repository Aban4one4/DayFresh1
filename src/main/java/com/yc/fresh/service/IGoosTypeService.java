package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.GoodsType;

public interface IGoosTypeService {

	  /**
	   * 找所有
	   * @return
	   */
	public List<GoodsType> findAll();
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<GoodsType> finds();
}

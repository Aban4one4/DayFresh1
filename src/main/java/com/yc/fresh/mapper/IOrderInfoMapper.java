package com.yc.fresh.mapper;

import java.util.Map;

import com.yc.fresh.entity.OrderInfo;

/**
 * 订单
 * @author Inspiron
 *
 */
public interface IOrderInfoMapper {
 
	/**
	 * 添加订单详细
	 * @param map
	 * @return
	 */
	public int add(OrderInfo of);

}

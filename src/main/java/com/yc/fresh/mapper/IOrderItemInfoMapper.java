package com.yc.fresh.mapper;

import java.util.Map;

/**
 * 订单
 * @author Inspiron
 *
 */
public interface IOrderItemInfoMapper {
 
	/**
	 * 添加订单详细
	 * @param map
	 * @return
	 */
	public int add(Map<String,Object> map);

}

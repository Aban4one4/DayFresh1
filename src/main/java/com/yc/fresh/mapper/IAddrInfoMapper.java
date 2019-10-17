package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;

/**
 * 地址
 * @author Inspiron
 *
 */
public interface IAddrInfoMapper {

  /**
   * 添加地址信息
   * @param af
   * @return
   */
	public int add(AddrInfo af);
	

	
	
	
	/**
	 * 修改默认地址
	 * @param anos
	 * @return
	 */
	public int updates(String[] anos);
	/**
	 * 查询指定会员的地址信息
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findByMno(int mno);
	

}

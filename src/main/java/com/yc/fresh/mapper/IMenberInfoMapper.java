package com.yc.fresh.mapper;


import com.yc.fresh.entity.MenberInfo;

/**
 * 前台登录
 * @author Inspiron
 *
 */
public interface IMenberInfoMapper {
   
	/**
	 * 登录的方法
	 * @param mb
	 * @return
	 */
	public MenberInfo login(MenberInfo mb);
	/**
	 *  添加游客账户的方法
	 * @param af
	 * @return
	 */
	public int add (MenberInfo mb);
	
	
	/**
	 * 查询所有
	 * @return
	 */

	
	
	/**
	 * 重置密码
	 * @param aid
	 * @return
	 */

	public int updatePwd(Integer mno);



}

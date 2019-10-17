package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.AdminInfo;

public interface IAdminInfoService {

	/**
	 * 后台管理员登录
	 * @param af
	 * @return
	 */
	public AdminInfo login(AdminInfo af);

	/**
	 *  添加后台管理信息
	 * @param af
	 * @return
	 */
	public int add (AdminInfo af);
	
	
	/**
	 * 查询所有
	 * @return
	 */

	public List<AdminInfo> findAll();
	
	
	/**
	 * 重置密码
	 * @param aid
	 * @return
	 */

	public int updatePwd(Integer aid);
	
}

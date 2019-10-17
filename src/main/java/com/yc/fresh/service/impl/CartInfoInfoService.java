package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.mapper.ICartInfoMapper;
import com.yc.fresh.service.ICartInfoService;
@Service
public class CartInfoInfoService implements ICartInfoService{
     @Autowired
	private ICartInfoMapper mapper;
      
	@Override
	public int add(CartInfo cf) {
		return mapper.add(cf);
	}

	@Override
	public List<CartInfo> findByMno(int mno) {
		return mapper.findByMno(mno);
	}

	@Override
	public int delete(String[] cnos) {
		return mapper.delete(cnos);
	}

	@Override
	public int deleteByCno(int cno) {
		return mapper.deleteByCno(cno);
	}

	@Override
	public int update(CartInfo cf) {
		return mapper.update(cf);
	}

	
	@Override
	public List<CartInfo> finds(int mno) {
	//	先冲redis中取出来
		/*System.out.println(redisDao.listRange(String.valueOf(mno), 0, -1));
	
		List<CartInfo> list=mapper.finds(mno);
		
		//存到redis中
		redisDao.listLeftPushAll(String.valueOf(mno), list);*/
		return mapper.finds(mno);
	}

	@Override
	public List<CartInfo> findByCnos(String[] cnos) {
		return mapper.findByCnos(cnos);
	} 
	

}

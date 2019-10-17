package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.mapper.IAddrInfoMapper;
import com.yc.fresh.service.IAddrInfoService;
import com.yc.fresh.util.StringUtil;
@Service
public class AddrInfoService implements IAddrInfoService{
     @Autowired
	private IAddrInfoMapper mapper;

	@Override
	public int add(AddrInfo af) {
	  if(StringUtil.isNull(af.getAno(),af.getProvince(),af.getCity(),af.getArea(),af.getName(),af.getTel())){
		  return -2;
	  }
		  int result=mapper.add(af);	
		  return result;
	}



	@Override
	public List<AddrInfo> findByMno(int mno) {
		return mapper.findByMno(mno);
	}



	@Override
	public int update(String[] anos) {
		if(anos.length<2){
			return -2;
		}
		return mapper.updates(anos);
	}

	

}

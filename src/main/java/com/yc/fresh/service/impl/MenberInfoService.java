package com.yc.fresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.mapper.IMenberInfoMapper;
import com.yc.fresh.service.IMenberInfoService;
import com.yc.fresh.util.StringUtil;
@Service
public class MenberInfoService  implements IMenberInfoService{
    @Autowired
	private IMenberInfoMapper mapper;
	@Override
	public MenberInfo login(MenberInfo mb) {
       if(StringUtil.isNull(mb.getPwd(),mb.getNickName())){
    	   return null;
       }
	return mapper.login(mb);
	}

	@Override
	public int add(MenberInfo mb) {
        if(StringUtil.isNull(mb.getNickName(),mb.getTel(),mb.getEmail())){
        	return -1;
        }
		return mapper.add(mb);
	}

	@Override
	public int updatePwd(Integer mno) {
       if(mno==null){
    	   return -1;
       }
		return mapper.updatePwd(mno);
	}

}

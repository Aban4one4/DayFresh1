package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.AdminInfo;
import com.yc.fresh.mapper.IAdminInfoMapper;
import com.yc.fresh.service.IAdminInfoService;
import com.yc.fresh.util.StringUtil;
@Service
public class AdminInfoService implements IAdminInfoService{
     @Autowired
	private IAdminInfoMapper mapper; 
	
	@Override
	public AdminInfo login(AdminInfo af) {
    if(StringUtil.isNull(af.getAname(),af.getPwd())){
    	return null;
    }
		return mapper.login(af);
	}

	@Override
	public int add(AdminInfo af) {
		 if(StringUtil.isNull(af.getAname(),af.getPwd(),af.getTel())){
		    	return -1;
		    }
				return mapper.add(af);
			
	}

	@Override
	public List<AdminInfo> findAll() {

		return mapper.findAll();
	}

	@Override
	public int updatePwd(Integer aid) {
          if(aid==null){
        	  return -1;
          }
		return mapper.updatePwd(aid);
	}

}

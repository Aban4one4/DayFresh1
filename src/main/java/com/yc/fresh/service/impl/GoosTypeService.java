package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.GoodsType;
import com.yc.fresh.mapper.IGoodsTypeMapper;
import com.yc.fresh.service.IGoosTypeService;

@Service
public class GoosTypeService implements IGoosTypeService {
    @Autowired
	private IGoodsTypeMapper mapper;
	
	@Override
	public List<GoodsType> findAll() {
		return mapper.findAll();
	}

	@Override
	public List<GoodsType> finds() {
		return mapper.finds();
	}

}

package com.yc.fresh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.entity.GoodsType;
import com.yc.fresh.mapper.IGoodsInfoMapper;
import com.yc.fresh.mapper.IGoodsTypeMapper;
import com.yc.fresh.service.IGoodsInfoService;
import com.yc.fresh.util.StringUtil;
@Service
public class GoodsInfoService  implements IGoodsInfoService {
    @Autowired
    private IGoodsInfoMapper mapper;
    @Autowired
    private IGoodsTypeMapper typemapper;
    
	@Override
	public int add(GoodsInfo gf) {
	if(StringUtil.isNull(gf.getGname(),gf.getPics())){
		return -1;
	}
	return mapper.add(gf);
	}

	@Override
	public Map<String, Object> finds() {
     //准备每种类型的前5条数据
		List<GoodsInfo> goods=mapper.finds();
		
		List<GoodsType> types=typemapper.findAll();
	Map<String,Object> map =new HashMap<String, Object>();
	map.put("types", types);
	map.put("goods", goods);

		return map;
	}

	@Override
	public List<GoodsInfo> findByType(int tno,int page,int rows) {
        Map<String, Integer> map=new HashMap<String,Integer>(); 
          
        map.put("page", (page-1)*rows);
        map.put("rows", rows);
        map.put("tno", tno);
        
		return mapper.findByType(map);
	}

	@Override
	public GoodsInfo findByGno(int gno) {
		return mapper.findByGno(gno);
	}



	@Override
	public Map<String, Object> findByFirst(int tno, int page, int rows) {
      List<GoodsInfo> goods=this.findByType(tno, page, rows);
      int total=mapper.getTotal(tno);
      
      Map<String,Object> resultmap=new HashMap<String,Object>();
      resultmap.put("goods", goods);
      resultmap.put("total", total);
      return resultmap;
	}

	@Override
	public GoodsInfo find(int gno) {
   
		return mapper.find(gno);
	}

}

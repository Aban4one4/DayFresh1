package com.yc.fresh.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.mapper.ICartInfoMapper;
import com.yc.fresh.mapper.IGoodsInfoMapper;
import com.yc.fresh.mapper.IOrderInfoMapper;
import com.yc.fresh.mapper.IOrderItemInfoMapper;
import com.yc.fresh.service.IOrderInfoService;
import com.yc.fresh.util.StringUtil;
@Service
public class OrderInfoService implements IOrderInfoService {
    @Autowired
	private IOrderInfoMapper orderMapper;
	@Autowired
    private IOrderItemInfoMapper itemMapper;
	@Autowired
    private ICartInfoMapper cartMapper;
	@Autowired
    private IGoodsInfoMapper goodsMapper;
	
	/**
	 * service需要进行的操作
	 * 创建一个订单
	 * 将选中的商品加入到订单详细表中
	 * 修改对应商品的库存量
	 * 将选中的商品从购物车中删除
	 * 这四个操作要求必须同时成功 ，所以加上事物
	 * 
	 * 
	 * 
	 */
	
    @Transactional
	@Override
	public int add(OrderInfo of) {
	 if(StringUtil.isNull(of.getOno(),of.getAno())){
		 return -2;
	 }
	String cnos=of.getOno();
	String ono=new Date().getTime() +""+new Random().nextInt(9999);//生成编号订单
	
	of.setOno(ono);
	
	int result =-1;
	result=orderMapper.add(of);
	 
	
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("ono", ono);
	map.put("cnos", cnos.split(","));
	
	
	result=itemMapper.add(map);
	
	
	result =goodsMapper.updateStore(cnos.split(","));
	
	result=cartMapper.delete(cnos.split(","));
	
	return result;
    	
    	
	}

}

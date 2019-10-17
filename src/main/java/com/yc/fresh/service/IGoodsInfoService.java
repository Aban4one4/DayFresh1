package com.yc.fresh.service;


import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoService {

  public int add(GoodsInfo gf);


  public Map<String,Object> finds();
  
  
  /**
   * 根据类型分页查询
   * @return
   */
  public List<GoodsInfo> findByType( int tno,int page,int rows);
  
  
  /**
   * 根据类型查商品信息
   * @return
   */
  public GoodsInfo findByGno(int gno);
  
  public Map<String,Object>findByFirst(int tno,int page,int rows);
  /**
   * 
   * @param gno
   * @return
   */
  public GoodsInfo find(int gno);

}

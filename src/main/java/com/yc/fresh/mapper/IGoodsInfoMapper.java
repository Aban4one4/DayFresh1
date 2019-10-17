package com.yc.fresh.mapper;


import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoMapper {

  public int add(GoodsInfo gf);
  
  /**
   * 查询每种类型的前四条数据
   * @return
   */
  public List<GoodsInfo> finds();
  
  
  /**
   * 根据类型分页查询
   * @return
   */
  public List<GoodsInfo> findByType(Map<String,Integer> map);
  
  
  /**
   * 根据类型查商品信息
   * @return
   */
  public GoodsInfo findByGno(int gno);
  /**
   * 根据类型取商品数量
   * @param tno
   * @return
   */
  public int getTotal(Integer tno);
  
  
  public int updateStore(String [] cnos);
  
  /**
   * 查询商品详情 根据gid
   * @param gf
   * @return
   */
  public GoodsInfo find(int gno);
}

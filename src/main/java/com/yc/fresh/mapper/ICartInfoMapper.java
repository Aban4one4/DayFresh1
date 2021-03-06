package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entity.CartInfo;

/**
 * 购物车类型
 * @author Inspiron
 *
 */
public interface ICartInfoMapper {
   /**
    * 加入购物车
    * @param cf
    * @return
    */
  public int add(CartInfo cf);
  
  
  /**
   *根据会员编号获取该会员的购物车信息
   * @param mno
   * @return
   */
  public List<CartInfo> findByMno(int mno);
  
  
  /**
   * 查数量
   * @param mno
   * @return
   */
  public List<CartInfo> finds(int mno);
  
  /**
   * 同时删除多个记录
   * @param gnos
   * @return
   */
  public int delete(String[] cnos);
  
  
  /**
   * 从购物车中移除商品
   * @param cno
   * @return
   */
  public int deleteByCno(int cno);
  
  /**
   * 修改数量
   * @param cf
   * @return
   */
  public int update(CartInfo cf);

  
  public List<CartInfo> findByCnos(String[] cnos);
}

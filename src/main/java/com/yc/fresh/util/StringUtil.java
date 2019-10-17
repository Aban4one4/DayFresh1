package com.yc.fresh.util;


public class StringUtil {
  //为空判断
	public  static boolean isNull(String...strs){
		if(strs ==null||strs.length==0){
			return true;
		}
	 for(String str :strs){
		 if(str ==null||"".equals(str)){
			 return true;
		 }
	 }
	return false;
	}
}

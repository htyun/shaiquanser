package jxnu.x3107.service;

import java.util.List;

import jxnu.x3107.bean.GoodsType;

public interface GoodsTypeService {
	public int addGoodsType(String userID,String releaserID,String releaserTime);//添加收藏
	public List<GoodsType> getGoodsTypeInfo(String userID);//得到收藏
	public int delGoodsType(String releaserID,String releaserTime);//删除收藏
}

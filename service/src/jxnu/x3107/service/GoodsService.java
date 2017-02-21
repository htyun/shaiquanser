package jxnu.x3107.service;

import java.util.List;

import jxnu.x3107.bean.Goods;

public interface GoodsService {
	public List<Goods> getGoodsInfo();//获得所以商品
	public List<Goods> getGoodsInfo(String stuNo);//获得个人发布商品
	public List<Goods> getClassGoodsInfo(String goodClassify);//获得分类发布商品
	public List<Goods> getSeekGoodsInfo(String goodName);//获得搜索发布商品
	public Goods getOlGoodsInfo(String goodName, String releaserID,String releaseTime);//获得单一商品
	public Goods getOlGoodsInfo( String releaserID,String releaseTime);//获得单一商品
	public int addGoods(Goods goods);//添加商品
	public int altGoodsInfo(Goods goods,String releaserID,String releaseTime);//修改商品信息
	public int deleteGoods(String releaserID,String releaseTime);//删除商品
	
	
	
	public int getRecordSize();//分页
	public List<Goods> getGoodsListByPage(int pageNow,int pageSize);//分页
	public int deletGoods(String releaseTime);//删除
	public Goods getGoodsTime(String releaseTime);//修改
	public int editGoods(Goods goods,String releaseTime);//修改
	public int insertGoods(Goods goods);//添加
	
}

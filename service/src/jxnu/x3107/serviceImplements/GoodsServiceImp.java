package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxnu.x3107.bean.Goods;
import jxnu.x3107.service.GoodsService;
import jxnu.x3107.sql.DBclass;

public class GoodsServiceImp implements GoodsService{

	DBclass db = new DBclass();
	ResultSet resultSet = null;


	@Override
	public List<Goods> getGoodsInfo() {
		List<Goods> gList = null;
		Goods goods = null;

		String strSql = "select * from goodsTable " + "order by goodID desc";
		resultSet = db.executeQuery(strSql);
		try {
			gList = new ArrayList<Goods>();
			while(resultSet.next()){

				goods = new Goods();
				goods.setGoodID(resultSet.getInt("goodID"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setFromSchoolID(resultSet.getString("fromSchoolID"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));

				if (goods.getGoodState() == 1) {

					gList.add(goods);
				}

			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gList;
	}

	@Override
	public List<Goods> getGoodsInfo(String stuNo) {
		List<Goods> gList = null;
		Goods goods = null;
		String strSql = "select * from goodsTable where releaserID='" + stuNo + "'" + " order by goodID desc";
		resultSet = db.executeQuery(strSql);
		try {
			gList = new ArrayList<Goods>();
			while(resultSet.next()){

				goods = new Goods();
				goods.setGoodID(resultSet.getInt("goodID"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setFromSchoolID(resultSet.getString("fromSchoolID"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));
				if (goods.getGoodState() == 1) {

					gList.add(goods);
				}		
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gList;
	}

	@Override
	public Goods getOlGoodsInfo(String goodName, String releaserID,String releaseTime) {

		Goods goods = null;
		String strSql = "select * from goodsTable where releaserID='" + releaserID + "' and goodName='" + goodName + "' and releaseTime='" + releaseTime + "'" + " order by goodID desc";
		System.out.println(strSql);
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				goods = new Goods();
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));


			}
			db.coloseConnection(db.connection);
		}
		catch (Exception e) {

		}
		return goods;
	}

	@Override
	public int addGoods(Goods goods) {

		int bl = 0;

		String strSql = "insert into goodsTable (goodName,goodLogo,goodIntroduction,releaseTime,fromWhere,goodState,price,releaserID,goodClassify,time) "
				+ "values "
				+ "("
				+ "'"+goods.getGoodName()+"',"
				+ "'"+goods.getGoodLogo()+"',"
				+ "'"+goods.getGoodIntroduction()+"',"
				+ "'"+goods.getReleaseTime()+"',"
				+ "'"+goods.getFromWhere()+"',"
				+ "'"+goods.getGoodState()+"',"
				+ "'"+goods.getPrice()+"',"
				+ "'"+goods.getReleaserID()+"',"
				+ "'"+goods.getGoodClassify()+"',"
				+ "'"+goods.getTime()+"'"
				+ ")";
		System.out.println(strSql);
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);
		return bl;
	}


	@Override
	public int altGoodsInfo(Goods goods,String releaserID,String releaseTime) {

		int bl = 0;

		String strSql = "UPDATE goodsTable  SET "
				+ "goodName = '"+goods.getGoodName()+"',"
				+ "goodIntroduction = '"+goods.getGoodIntroduction()+"',"
				+ "price = '"+goods.getPrice()+"',"
				+ "goodClassify = '"+goods.getGoodClassify()+"'	"
				+ " WHERE releaserID='"+releaserID+"' "
				+ "and releaseTime='"+releaseTime+"'";

		System.out.println(strSql);
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);
		return bl;
	}

	@Override
	public int deleteGoods(String releaserID,String releaseTime) {
		int bl = 0;


		String strSql = "DELETE FROM goodsTable WHERE releaserID='"+releaserID+"' and releaseTime='"+releaseTime+"'";

		System.out.println(strSql);
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);

		return bl;
	}

	@Override
	public List<Goods> getClassGoodsInfo(String goodClassify) {
		List<Goods> gList = null;
		Goods goods = null;
		String strSql = "select * from goodsTable where goodClassify='" + goodClassify + "'" + " order by goodID desc";
		resultSet = db.executeQuery(strSql);
		try {
			gList = new ArrayList<Goods>();
			while(resultSet.next()){

				goods = new Goods();
				goods.setGoodID(resultSet.getInt("goodID"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setFromSchoolID(resultSet.getString("fromSchoolID"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));
				if (goods.getGoodState() == 1) {

					gList.add(goods);
				}
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gList;
	}

	@Override
	public List<Goods> getSeekGoodsInfo(String goodName) {
		List<Goods> gList = null;
		Goods goods = null;

		String strSql = "select * from goodsTable where goodName like '%"+ goodName +"%' or goodIntroduction like '%"+ goodName +"%' order by goodID desc";
		System.out.println(strSql);
		resultSet = db.executeQuery(strSql);
		try {
			gList = new ArrayList<Goods>();
			while(resultSet.next()){

				goods = new Goods();
				goods.setGoodID(resultSet.getInt("goodID"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setFromSchoolID(resultSet.getString("fromSchoolID"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));
				if (goods.getGoodState() == 1) {

					gList.add(goods);
				}
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gList;
	}

	@Override
	public Goods getOlGoodsInfo(String releaserID, String releaseTime) {

		Goods goods = null;
		String strSql = "select * from goodsTable where releaserID='" + releaserID + "' and releaseTime='" + releaseTime + "'  order by goodID desc";
		System.out.println(strSql);
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				goods = new Goods();
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));


			}
			db.coloseConnection(db.connection);
		}
		catch (Exception e) {

		}
		return goods;
	}
	/******************************************************************************************************************************/
	/*
	 * 管理员
	 * 
	 * */
	@Override
	public int getRecordSize() {

		int count = 0;
		String strSql = "select count(*) from goodsTable";
		resultSet = db.executeQuery(strSql);

		try {
			while(resultSet.next()){
				count = resultSet.getInt(1);
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Goods> getGoodsListByPage(int pageNow,int pageSize) {

		List<Goods> goodsList = new ArrayList<Goods>();
		String strSql = "select top "+pageSize+" * from goodsTable where goodID not in ("
				+"select top "+(pageNow-1)*pageSize+" goodID from goodsTable)";
		resultSet=db.executeQuery(strSql);

		try {
			while(resultSet.next()){
				Goods goods = new Goods();
				goods.setGoodID(resultSet.getInt("goodID"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setReleaseTime(resultSet.getString("releaseTime"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setReleaserID(resultSet.getString("releaserID"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
				goods.setTime(resultSet.getString("time"));
				goodsList.add(goods);
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goodsList;
	}

	@Override
	public int deletGoods(String releaseTime) {
		int bl = 0;
		String strSql = "delete from goodsTable where releaseTime='" + releaseTime + "'";
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);
		return bl;
	}

	@Override
	public Goods getGoodsTime(String releaseTime) {

		Goods goods = null;

		String strSql = "select * from goodsTable where releaseTime='"+releaseTime+"'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				goods = new Goods();
				goods.setGoodLogo(resultSet.getString("goodLogo"));
				goods.setGoodName(resultSet.getString("goodName"));
				goods.setGoodIntroduction(resultSet.getString("goodIntroduction"));
				goods.setFromWhere(resultSet.getString("fromWhere"));
				goods.setGoodState(resultSet.getInt("goodState"));
				goods.setPrice(resultSet.getDouble("price"));
				goods.setGoodClassify(resultSet.getString("goodClassify"));
			}

			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return goods;
	}

	@Override
	public int editGoods(Goods goods, String releaseTime) {

		int bl = 0;

		String strSql = "update goodsTable set "
				+ "goodName='"+goods.getGoodName()+"',"
				+ "goodIntroduction='"+goods.getGoodIntroduction()+"',"
				+ "fromWhere='"+goods.getFromWhere()+"',"
				+ "goodState='"+goods.getGoodState()+"',"
				+ "price='"+goods.getPrice()+"',"
				+ "goodClassify='"+goods.getGoodClassify()+"' "
				+ "where releaseTime='"+releaseTime+"'";

		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);

		return bl;
	}

	@Override
	public int insertGoods(Goods goods) {
		
		int bl = 0;
		String strSql = "insert into goodsTable (goodName,goodLogo,goodIntroduction,releaseTime,fromWhere,goodState,price,releaserID,goodClassify,time) "
				+ "values "
				+ "('"+goods.getGoodName()+"',"
				+ "'"+goods.getGoodLogo()+"',"
				+ "'"+goods.getGoodIntroduction()+"',"
				+ "'"+goods.getReleaseTime()+"',"
				+ "'"+goods.getFromWhere()+"',"
				+ "'"+goods.getGoodState()+"',"
				+ "'"+goods.getPrice()+"',"
				+ "'"+goods.getReleaserID()+"',"
				+ "'"+goods.getGoodClassify()+"',"
				+ "'"+goods.getTime()+"')";
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);

		return bl;
	}


}

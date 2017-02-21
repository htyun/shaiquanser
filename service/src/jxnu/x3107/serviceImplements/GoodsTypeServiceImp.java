package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxnu.x3107.bean.GoodsType;
import jxnu.x3107.service.GoodsTypeService;
import jxnu.x3107.sql.DBclass;

public class GoodsTypeServiceImp implements GoodsTypeService{

	DBclass db = new DBclass();
	ResultSet resultSet = null;
	
	@Override
	public int addGoodsType(String userID, String releaserID, String releaserTime) {
		
		int bl = 0;
		
		String strSql = "insert into goodsTypeTable (userID,releaserID,releaseTime) "
				+ "values "
				+ "('"+userID+"',"
				+ "'"+releaserID+"',"
				+ "'"+releaserTime+"'"
				+ ")";
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);
		
		return bl;
	}

	@Override
	public List<GoodsType> getGoodsTypeInfo(String userID) {
		
		List<GoodsType> gtList = null;
		
		String strSql = "select * from goodsTypeTable where userID='" + userID + "'";
		System.out.println(strSql);
		resultSet = db.executeQuery(strSql);
		try {
			gtList = new ArrayList<GoodsType>();
			while(resultSet.next()){
				GoodsType goodsType = new GoodsType();
				goodsType.setUserID(resultSet.getString("userID"));
				goodsType.setReleaserID(resultSet.getString("releaserID"));
				goodsType.setReleaseTime(resultSet.getString("releaseTime"));
				gtList.add(goodsType);
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return gtList;
	}

	@Override
	public int delGoodsType(String releaserID,String releaserTime) {
		
		int bl = 0;
		String stSql = "  delete from goodsTypeTable where releaserID='"+releaserID+"' and releaseTime='"+releaserTime+"'";
		
		bl = db.executeUpdate(stSql);
		
		db.coloseConnection(db.connection);
		return bl;
	}

}

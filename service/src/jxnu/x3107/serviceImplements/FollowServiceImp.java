package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxnu.x3107.bean.Follow;
import jxnu.x3107.service.FollowService;
import jxnu.x3107.sql.DBclass;

public class FollowServiceImp implements FollowService{

	DBclass db = new DBclass();
	ResultSet resultSet = null;
	
	
	@Override
	public List<Follow> getFollowInfo(String userID) {
//		select * from followTable where userID='12'
		List<Follow> fList = null;
		String strSql = "select * from followTable where userID='"+userID+"'";
		resultSet = db.executeQuery(strSql);
		fList = new ArrayList<Follow>();
		try {
			while (resultSet.next()) {
				
				Follow follow = new Follow();
				follow.setUserID(resultSet.getString("userID"));
				follow.setReleaserID(resultSet.getString("releaserID"));
				fList.add(follow);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		db.coloseConnection(db.connection);
		return fList;
	}

	@Override
	public int addFollow(String userID, String releaserID) {
//		insert into followTable (userID,releaserID) values ('12','123')
		int bl = 0;
		
		String strSql = "insert into followTable (userID,releaserID) values ('"+userID+"','"+releaserID+"')";
		bl = db.executeUpdate(strSql);
		
		db.coloseConnection(db.connection);
		return bl;
	}

	@Override
	public int delFollow(String releaserID) {
//		delete from followTable where releaserID='123'
		int bl = 0;
		
		String strSql = "delete from followTable where releaserID='"+releaserID+"'";
		
		bl = db.executeUpdate(strSql);
		
		db.coloseConnection(db.connection);
		return bl;
	}

}

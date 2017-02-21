package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;

import jxnu.x3107.bean.School;
import jxnu.x3107.service.SchoolService;
import jxnu.x3107.sql.DBclass;

public class SchoolServiceImp implements SchoolService{

	DBclass db = new DBclass();
	ResultSet resultSet = null;

	@Override
	public int addSchool(School school) {

		int bl = 0;

		String strSql = "insert into schoolTable(schoolNumber,schoolPw,schoolName) values"
				+ "('"+school.getSchoolNumber()+"',"
				+ "'"+school.getSchoolPw()+"',"
				+ "'"+school.getSchoolName()+"'"
				+ ")";

		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);

		return bl;
	}

	@Override
	public int alterSchool(School school,  String id) {

		int bl = 0;

		String strSql = "update schoolTable set schoolPw='"+school.getSchoolPw()+"' where schoolNumber='"+id +"'";
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);

		return bl;
	}

	@Override
	public School getSchoolInfo(String id) {

		School school = new School();
		String strSql = "select * from schoolTable where schoolNumber='"+id+"'";
		resultSet = db.executeQuery(strSql);
		try{
			while(resultSet.next()){
				school.setSchoolName(resultSet.getString("schoolName"));
				school.setSchoolID(resultSet.getInt("schoolID"));
				school.setSchoolPw(resultSet.getString("schoolPw"));
				school.setSchoolNumber(resultSet.getString("schoolNumber"));
			}
			db.coloseConnection(db.connection);
		}catch(Exception e){
			e.printStackTrace();
		}
		return school;
	}

	@Override
	public boolean YZXH(String schoolNumber, String schoolPw) {

		boolean bl = false;
		School school = new School();
		String strSql = "select schoolPw from schoolTable where schoolNumber='"+schoolNumber+"'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				school.setSchoolPw(resultSet.getString("schoolPw"));
				if(school.getSchoolPw().equals(schoolPw)){
					bl = true;
					return bl;
				}
			}
			
			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bl;
	}

	@Override
	public int deletInfo(String schoolNumber) {
		
		int bl = 0;
		
		String strSql = "delete from schoolTable where schoolNumber='" + schoolNumber + "'";
		bl = db.executeUpdate(strSql);
		db.coloseConnection(db.connection);
		return bl;
	}

}

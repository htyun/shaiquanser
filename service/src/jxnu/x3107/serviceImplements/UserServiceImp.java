package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxnu.x3107.bean.User;
import jxnu.x3107.service.UserService;
import jxnu.x3107.sql.DBclass;

public class UserServiceImp implements UserService{

	DBclass db = new DBclass();
	ResultSet resultSet = null;

	@Override
	public int addUser(User user) {

		int bl = 0;

		String strSql = "insert into userTable (userName,userPw,stuNo,stuName) values "
				+ "('"+user.getUserName()+"',"
				+ "'"+user.getUserPw()+"',"
				+ "'"+user.getStuNo()+"',"
				+"'"+user.getStuName()+"'"
				+ ")";

		System.out.println(strSql);

		bl = db.executeUpdate(strSql);

		db.coloseConnection(db.connection);

		return bl;
	}

	public User yzAll(String info,int n){
		User user = null;
		switch (n) {
		case 1:
			String strSql1 = "select * from userTable where userQQ='"+info+"'";
			resultSet = db.executeQuery(strSql1);
			try {
				while(resultSet.next()){
					user = new User();
					user.setQq(resultSet.getString("userQQ"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			String strSql2 = "select * from userTable where userEmail='"+info+"'";
			resultSet = db.executeQuery(strSql2);
			try {
				while(resultSet.next()){
					user = new User();
					user.setUserEmail(resultSet.getString("userEmail"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			String strSql3 = "select * from userTable where userTel='"+info+"'";
			resultSet = db.executeQuery(strSql3);
			try {
				while(resultSet.next()){
					user = new User();
					user.setUserTel(resultSet.getString("userTel"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}


		return user;
	}

	@Override
	public int alterUser(String userInfo,int n,String stuNo) {

		int bl = 0;

		switch (n) {
		case 1://修改用户名

			if (getUserInfo(userInfo) != null) {
				bl = 0;
				return bl;
			}

			String strSql1= "update userTable set userName='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql1);
			db.coloseConnection(db.connection);
			break;
		case 2://修改性别

			String strSql2 = "update userTable set userSex='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql2);
			db.coloseConnection(db.connection);
			break;

		case 3://修改简介

			String strSql3 = "update userTable set introduction='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql3);
			db.coloseConnection(db.connection);
			break;

		case 4://修改生日

			String strSql4 = "update userTable set birth='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql4);
			db.coloseConnection(db.connection);
			break;

		case 5://修改QQ
			if (yzAll(userInfo, 1) != null) {
				bl = 0;
				return bl;
			}

			String strSql5 = "update userTable set userQQ='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql5);
			db.coloseConnection(db.connection);
			break;

		case 6://修改Email
			if (yzAll(userInfo, 2) != null) {
				bl = 0;
				return bl;
			}
			String strSql6 = "update userTable set userEmail='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql6);
			db.coloseConnection(db.connection);
			break;

		case 7://修改电话号码
			if (yzAll(userInfo, 3) != null) {
				bl = 0;
				return bl;
			}
			String strSql7 = "update userTable set userTel='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql7);
			db.coloseConnection(db.connection);
			break;

		case 8://修改密码

			String strSql8 = "update userTable set userPw='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql8);
			db.coloseConnection(db.connection);
			break;

		case 9://修改头像

			String strSql9 = "update userTable set userLogo='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql9);
			db.coloseConnection(db.connection);
			break;
		case 10://修改学校

			String strSql10 = "update userTable set stuName='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql10);
			db.coloseConnection(db.connection);
			break;
		case 11://修改地址

			String strSql11 = "update userTable set userCity='"+userInfo+"' where stuNo='"+stuNo+"'";
			bl = db.executeUpdate(strSql11);
			db.coloseConnection(db.connection);
			break;

		default:
			break;
		}

		return bl;
	}

	@Override
	public String loginYZ(User user) {

		String bl = "";

		String strSql = "select * from userTable";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				if(user.getUserName().equals(resultSet.getString("userName"))
						&& user.getUserPw().equals(resultSet.getString("userPw"))  
						){
					bl = "userName";
					break;
				}
				if ( user.getUserName().equals(resultSet.getString("stuNo"))
						&& user.getUserPw().equals(resultSet.getString("userPw"))) {
					bl = "stuNo";
					break;
				}
			}
			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bl;
	}
	//验证是否重复
	@Override
	public boolean YZCF(String userName){

		boolean bl=false;
		String sql="select * from userTable where userName='"+userName+"'";				  
		resultSet=db.executeQuery(sql);
		try {
			while(resultSet.next()){
				if(resultSet.getString("userName").trim().equals(userName)){
					bl=true;
					break;
				}

			}

			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public User getUserInfo(String userName) {

		User user= new User();

		String strSql = "select * from userTable where userName='"+userName+"'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				user.setUserLogo(resultSet.getString("userLogo"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserSex(resultSet.getString("userSex"));
				user.setIntroduction(resultSet.getString("introduction"));
				user.setBirth(resultSet.getString("birth"));
				user.setQq(resultSet.getString("userQQ"));
				user.setUserEmail(resultSet.getString("userEmail"));
				user.setUserTel(resultSet.getString("userTel"));
				user.setStuName(resultSet.getString("stuName"));
				user.setUserCity(resultSet.getString("userCity"));
				user.setStuNo(resultSet.getString("stuNo"));


			}

			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return user;
	}

	@Override
	public User getUserInfoOther(String stuNo) {
		User user= new User();

		String strSql = "select * from userTable where stuNo='"+stuNo+"'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				user.setUserLogo(resultSet.getString("userLogo"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserSex(resultSet.getString("userSex"));
				user.setIntroduction(resultSet.getString("introduction"));
				user.setBirth(resultSet.getString("birth"));
				user.setQq(resultSet.getString("userQQ"));
				user.setUserEmail(resultSet.getString("userEmail"));
				user.setUserTel(resultSet.getString("userTel"));
				user.setStuName(resultSet.getString("stuName"));
				user.setUserCity(resultSet.getString("userCity"));
				user.setStuNo(resultSet.getString("stuNo"));


			}

			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return user;
	}

	@Override
	public int alterUnTelUser(int unTel, String userInfo,String userPw) {

		int bl = 0;

		switch (unTel) {
		case 1://学号修改密码
			String strSql1 = "update userTable set userPw='"+userPw+"' where stuNo='"+userInfo+"'";
			bl = db.executeUpdate(strSql1);
			db.coloseConnection(db.connection);
			break;
		case 2://电话号码改密码
			String strSql2 = "update userTable set userPw='"+userPw+"' where userTel='"+userInfo+"'";
			bl = db.executeUpdate(strSql2);
			db.coloseConnection(db.connection);
			break;

		default:
			break;
		}

		return bl;
	}

	@Override
	public boolean YZTEL(String userTel) {

		boolean bl = false;

		String strSql = "select userTel from userTable where userTel='" + userTel + "'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				if(resultSet.getString("userTel").equals(userTel) ){
					bl = true;
					return bl;
				}
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return bl;
	}
	/****************************************************************************************************************/
	/*
	 * 管理员
	 * */
	@Override
	public List<User> getAllUser() {

		List<User> uList = new ArrayList<User>();

		String strSql = "select * from userTable";

		resultSet = db.executeQuery(strSql);
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setUserLogo(resultSet.getString("userLogo"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPw(resultSet.getString("userPw"));
				user.setUserSex(resultSet.getString("userSex"));
				user.setIntroduction(resultSet.getString("introduction"));
				user.setBirth(resultSet.getString("birth"));
				user.setQq(resultSet.getString("userQQ"));
				user.setUserEmail(resultSet.getString("userEmail"));
				user.setUserTel(resultSet.getString("userTel"));
				user.setStuName(resultSet.getString("stuName"));
				user.setUserCity(resultSet.getString("userCity"));
				user.setStuNo(resultSet.getString("stuNo"));

				uList.add(user);

			}

			System.out.println(uList.size() + "uList.size");

			db.coloseConnection(db.connection);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return uList;
	}

	@Override
	public int getRecordSize() {
		int count = 0;
		String strSql = "select count(*) from userTable";
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
	public List<User> getUserListByPage(int pageNow, int pageSize) {
		List<User> uList = new ArrayList<User>();
		String strSql = "select top "+pageSize+" * from userTable where userID not in ("
				+"select top "+(pageNow-1)*pageSize+" userID from userTable)";
		resultSet=db.executeQuery(strSql);

		try {
			while(resultSet.next()){
				User user = new User();
				user.setUserLogo(resultSet.getString("userLogo"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPw(resultSet.getString("userPw"));
				user.setUserSex(resultSet.getString("userSex"));
				user.setIntroduction(resultSet.getString("introduction"));
				user.setBirth(resultSet.getString("birth"));
				user.setQq(resultSet.getString("userQQ"));
				user.setUserEmail(resultSet.getString("userEmail"));
				user.setUserTel(resultSet.getString("userTel"));
				user.setStuName(resultSet.getString("stuName"));
				user.setUserCity(resultSet.getString("userCity"));
				user.setStuNo(resultSet.getString("stuNo"));

				uList.add(user);
			}
			db.coloseConnection(db.connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return uList;
	}

	@Override
	public int deletUser(String stuNo) {

		int lg = 0;


		String sqlsrt = "delete from userTable where stuNo='"+stuNo+"'";
		lg = db.executeUpdate(sqlsrt);

		db.coloseConnection(db.connection);
		return lg;
	}

	@Override
	public int editUser(User user, String stuNo) {

		int lg = 0;

		String sqlStr = "update userTable set"
				+ " userName='"+user.getUserName()+"' ,"
				+ "userPw='"+user.getUserPw()+"',"
				+ "userSex='"+user.getUserSex()+"',"
				+ "userCity='"+user.getUserCity()+"',"
				+ "stuName='"+user.getStuName()+"',"
				+ "birth='"+user.getBirth()+"',"
				+ "userEmail='"+user.getUserEmail()+"',"
				+ "introduction='"+user.getIntroduction()+"',"
				+ "userQQ='"+user.getQq()+"',"
				+ "userTel='"+user.getUserTel()+"' "
				+ "where stuNo='"+stuNo+"'";

		lg = db.executeUpdate(sqlStr);
		db.coloseConnection(db.connection);
		return lg;

	}

	public User editUserInfo(String stuNo) {
		User user= new User();

		String strSql = "select * from userTable where stuNo='"+stuNo+"'";
		resultSet = db.executeQuery(strSql);
		try {
			while(resultSet.next()){
				user.setUserLogo(resultSet.getString("userLogo"));
				user.setUserPw(resultSet.getString("userPw"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserSex(resultSet.getString("userSex"));
				user.setIntroduction(resultSet.getString("introduction"));
				user.setBirth(resultSet.getString("birth"));
				user.setQq(resultSet.getString("userQQ"));
				user.setUserEmail(resultSet.getString("userEmail"));
				user.setUserTel(resultSet.getString("userTel"));
				user.setStuName(resultSet.getString("stuName"));
				user.setUserCity(resultSet.getString("userCity"));


			}

			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return user;
	}

	@Override
	public int insertUser(User user) {

		int bl = 0;

		String strSql = "insert into userTable (userName ,userPw,userSex,userCity,stuName,stuNo,birth,userEmail,introduction,userQQ,userTel,userLogo) values "
				+ "('"+user.getUserName()+"',"
				+ "'"+user.getUserPw()+"',"
				+ "'"+user.getUserSex()+"',"
				+ "'"+user.getUserCity()+"',"
				+ "'"+user.getStuName()+"',"
				+ "'"+user.getStuNo()+"',"
				+ "'"+user.getBirth()+"',"
				+ "'"+user.getUserEmail()+"',"
				+ "'"+user.getIntroduction()+"',"
				+ "'"+user.getQq()+"',"
				+"'"+user.getUserTel()+"',"
				+"'"+user.getUserLogo()+"'"
				+ ")";

		System.out.println(strSql);

		bl = db.executeUpdate(strSql);

		db.coloseConnection(db.connection);

		return bl;
	}


}

package jxnu.x3107.serviceImplements;

import java.sql.ResultSet;

import jxnu.x3107.bean.Manager;
import jxnu.x3107.service.ManagerService;
import jxnu.x3107.sql.DBclass;

/*
 * 实现管理员功能类
 * */

public class ManagerServiceImp implements ManagerService{

	DBclass db = new DBclass();

	ResultSet resultSet = null;
	/*
	 * 添加管理员
	 */
	@Override
	public int addManager(Manager manager) {

		int bl = 0;
		String strSql = "insert into managerTable(managerName,managerPw,managerEmail,managerLogo) values"
				+ "('"+manager.getManagerName()+"',"
				+ "'"+manager.getManagerPw()+"',"
				+ "'"+manager.getManagerEmail()+"',"
				+ "'"+manager.getManagerLogo()+"')";
		bl = db.executeUpdate(strSql);

		db.coloseConnection(db.connection);

		return bl;
	}


	/*
	 * 管理员验证
	 */
	@Override
	public boolean YZ(Manager manager) {

		String strSql = "select * from managerTable";
		resultSet = db.executeQuery(strSql);
		boolean bl = false;

		try {
			while(resultSet.next()){
				if(manager.getManagerName().equals(resultSet.getString("managerName")) && 
						manager.getManagerPw().equals(resultSet.getString("managerPw"))){
					bl = true;
					break;
				}	
			}
			db.coloseConnection(db.connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return bl;
	}


	/*
	 * 修改信息
	 */
	@Override
	public int editManager(Manager manager) {
		return 0;
	}

}

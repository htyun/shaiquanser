package jxnu.x3107.service;

import jxnu.x3107.bean.Manager;

/*
 * 管理员服务接口
 * */

public interface ManagerService {
	/*
	 * 添加管理员
	 */
	public int addManager(Manager manager);
	
	/*
	 * 管理员验证
	 */
	public boolean YZ(Manager manager);
	
	/*
	 * 修改信息
	 */
	public int editManager(Manager manager);
}

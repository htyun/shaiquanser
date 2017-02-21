package jxnu.x3107.service;

import java.util.List;

import jxnu.x3107.bean.User;

public interface UserService {
	public int addUser(User user);//注册用户
	public int alterUser(String userInfo,int n,String userName);//修改用户资料
	public int alterUnTelUser(int unTel,String userInfo,String userPw);//学号修改密码
	public boolean YZTEL(String userTel);//电话号码是否存在
	public String loginYZ(User user);//登陆验证
	public User getUserInfo(String userName);//获取用户信息
	public User getUserInfoOther(String stuNo);//获取用户信息
	public boolean YZCF(String userName);//验证是否重复





	public List<User> getAllUser();//得到所有用户
	public int getRecordSize();//分页
	public List<User> getUserListByPage(int pageNow,int pageSize);//分页
	public int deletUser(String stuNo);//删除用户
	public int editUser(User user,String stuNo);//修改信息
	public User editUserInfo(String stuNo);//获取信息
	public int insertUser(User user);//添加信息
}

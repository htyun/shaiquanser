package jxnu.x3107.service;

import jxnu.x3107.bean.School;

public interface SchoolService {
	public int addSchool(School school);//添加学校信息
	public int alterSchool(School school,String id);//修改学校信息
	public School getSchoolInfo(String id);//获取学校信息id为学号
	public boolean YZXH(String schoolNumber,String schoolPw);//学号，密码验证
	
	
	
	public int deletInfo(String schoolNumber);
}

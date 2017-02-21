package jxnu.x3107.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.School;
import jxnu.x3107.bean.User;
import jxnu.x3107.service.SchoolService;
import jxnu.x3107.service.UserService;
import jxnu.x3107.serviceImplements.SchoolServiceImp;
import jxnu.x3107.serviceImplements.UserServiceImp;

public class UserInfoAction extends ActionSupport{


	UserService uService = new UserServiceImp();
	SchoolService sService = new SchoolServiceImp();
	private List<User> userList ;



	//	得到用户列表	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getUserInfo(){


		userList = uService.getAllUser();
		System.out.println(userList.size());

		return "uInSU";
	}

	private String stuNo;
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	//删除
	public String deletUser(){
		String str = "deletFA";
		User userLogo = new User();
		System.out.println(stuNo);
		userLogo = uService.editUserInfo(stuNo);
		System.out.println(userLogo.getUserLogo());
		
		File file = new File("C:\\windowsserver\\Project\\ShaiquanServer\\userLogo/" + userLogo.getUserLogo());
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
			} else {
			}
		} else {
			file.delete();
		}
		
		
		if ((uService.deletUser(stuNo) != 0) && (sService.deletInfo(stuNo) != 0)) {
				
				str = "deletSU";
		}

		return str;
	}
	public  User user;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	//修改
	public String eidtUser(){
		String str = "editFA";
		Map<String ,Object> session = ActionContext.getContext().getSession();
		if ((uService.editUser(user, (String) session.get("stuNo")) != 0) && (sService.alterSchool(school, (String) session.get("stuNo"))!= 0)) {
			str = "editSU";
		}

		return str;
	}
	public String eidt(){

		String str = "editSU";
		Map<String ,Object> session = ActionContext.getContext().getSession();
		session.put("stuNo", getStuNo()+"");
		user = uService.editUserInfo(stuNo);
		school = sService.getSchoolInfo(stuNo);


		return str;
	}
	//添加
	private String userLogo;
	private String userLogoFileName;//Struts2提供的格式，在文件名后+FileName就是上传文件的名字  
	private String userLogoContentType;//文件类型

	public String getUserLogo() {
		return userLogo;
	}
	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}
	public String getUserLogoFileName() {
		return userLogoFileName;
	}
	public void setUserLogoFileName(String userLogoFileName) {
		this.userLogoFileName = userLogoFileName;
	}
	public String getUserLogoContentType() {
		return userLogoContentType;
	}
	public void setUserLogoContentType(String userLogoContentType) {
		this.userLogoContentType = userLogoContentType;
	}
	public School school;
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	public String insertUser(){
		String str = "insFA";

		
		System.out.println(user.getStuNo());
		System.out.println(user.getStuName());
		System.out.println(school.getSchoolPw());
		
		school.setSchoolNumber(user.getStuNo());
		school.setSchoolName(user.getStuName());
		
		String logoName = "C:\\windowsserver\\Project\\ShaiquanServer\\userLogo/head_" + user.getStuNo()+".jpg";
		try {
			FileOutputStream fos = new FileOutputStream(logoName);
			FileInputStream fis = new FileInputStream(getUserLogo());
			byte [] b = new byte[1024];
			int len = 0;
			while((len = fis.read(b)) > 0){
				fos.write(b,0,len);
			}

			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		user.setUserLogo("head_" + user.getStuNo()+".jpg");
		if ((uService.insertUser(user) != 0) && (sService.addSchool(school) != 0)) {
				
				str = "insSU";
		}

		return str;
	}



	private int pageSize = 5;//每页要显示的记录数
	private int recordsize = 0;//表中总的记录数
	private int pageCount = 0;//总的页数
	private int pageNow=1;//当前是第几页
	//分页
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordsize() {
		return recordsize;
	}
	public void setRecordsize(int recordsize) {
		this.recordsize = recordsize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public String usersByPage(){
		String str = "pageF";

		recordsize =  uService.getRecordSize();
		if (recordsize % pageSize == 0) {
			pageCount = recordsize/pageSize;
		}else {
			pageCount = recordsize/pageSize+1;
		}
		if(pageNow<1){
			pageNow=1;
		}
		if(pageNow>pageCount){
			pageNow=pageCount;
		}

		userList = uService.getUserListByPage(pageNow, pageSize);
		if (userList.size() != 0) {
			str = "pageSU";
		}

		return str;
	}




}

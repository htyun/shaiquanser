package jxnu.x3107.action;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.School;
import jxnu.x3107.bean.User;
import jxnu.x3107.service.SchoolService;
import jxnu.x3107.service.UserService;
import jxnu.x3107.serviceImplements.SchoolServiceImp;
import jxnu.x3107.serviceImplements.UserServiceImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActivityUserRegLogAction extends ActionSupport{

	private String userName;//用户名
	private String userPw;//用户密码
	private String stuNo;//学号
	private String schoolPw;//学号密码
	private String schoolName;//学校名称

	private String userInfo;//修改用户信息
	private int n;
	private int unTel;
	private String unTelInfo;




	UserService uService = new UserServiceImp();
	SchoolService sService = new SchoolServiceImp();

	HttpServletResponse response = ServletActionContext.getResponse();

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getSchoolPw() {
		return schoolPw;
	}
	public void setSchoolPw(String schoolPw) {
		this.schoolPw = schoolPw;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getUnTel() {
		return unTel;
	}
	public void setUnTel(int unTel) {
		this.unTel = unTel;
	}
	public String getUnTelInfo() {
		return unTelInfo;
	}
	public void setUnTelInfo(String unTelInfo) {
		this.unTelInfo = unTelInfo;
	}

	//用户注册
	public void activityRegUser(){

		User user = new User();
		School school = new School();


		user.setUserName(getUserName());
		user.setUserPw(getUserPw());
		user.setStuNo(getStuNo());
		user.setStuName(getSchoolName());


		school.setSchoolNumber(getStuNo());
		school.setSchoolPw(getSchoolPw());
		school.setSchoolName(getSchoolName());



		JSONObject jsonObject = new JSONObject();

		if(uService.YZCF(getUserName())){
			jsonObject.put("regResult", "CF");//是否已经存在

		}else {



			if(uService.addUser(user) != 0 && sService.addSchool(school) != 0){



				jsonObject.put("regResult","Y");

			}else {
				jsonObject.put("regResult", "N");
			}

		}
		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			byte [] buffer = jsonObject.toString().getBytes("utf-8");

			response.setContentLength(buffer.length);
			response.getOutputStream().write(buffer);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	//用户登录
	public void activityLogUser(){

		User user = new User();
		user.setUserName(getUserName());
		user.setUserPw(getUserPw());

		JSONObject jsonObject = new JSONObject();

		if(uService.loginYZ(user).equals("userName")){
			jsonObject.put("logResult", "userNameY");
		}else if (uService.loginYZ(user).equals("stuNo")) {
			
			jsonObject.put("logResult", "stuNoY");
		}else {
			jsonObject.put("logResult", "N");
		}

		try {
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			byte [] buffer = jsonObject.toString().getBytes("utf-8");

			response.setContentLength(buffer.length);
			response.getOutputStream().write(buffer);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}



	//获取用户信息
	public void activityUserInfo(){

		// JSON格式数据解析对象
		JSONObject jsonObject = new JSONObject();

		User user = uService.getUserInfo(userName);
		if(user != null){
			// 将Bean转换为JSONArray数据
			JSONArray jsonArray = JSONArray.fromObject(user);

			System.out.println("jsonarray:" + jsonArray.toString());

			jsonObject.put("info", jsonArray);
		}


		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonObject.toString());
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}




	}
	//获取用户信息
	public void activityUserInfoOther(){

		// JSON格式数据解析对象
		JSONObject jsonObject = new JSONObject();

		User user = uService.getUserInfoOther(getStuNo());
		if(user != null){
			// 将Bean转换为JSONArray数据
			JSONArray jsonArray = JSONArray.fromObject(user);

			System.out.println("jsonarray:" + jsonArray.toString());

			jsonObject.put("infoOther", jsonArray);
		}


		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonObject.toString());
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}




	}



	//修改user信息
	public void activityAlUserInfo(){

		JSONObject jsonObject = new JSONObject();


		if(uService.alterUser(getUserInfo(), getN(), getStuNo()) != 0){
			jsonObject.put("alResult", "Y");
		}else {
			jsonObject.put("alResult", "N");
		}

		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonObject.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//学号密码学号修改密码
	public void actAlPassword(){

		JSONObject jsonObject = new JSONObject();

		if(unTel == 1){
			if(sService.YZXH(stuNo, schoolPw)){
				uService.alterUnTelUser(1, stuNo, userPw);
				jsonObject.put("actalResult", "Y");
			}else {
				jsonObject.put("actalResult", "N");
			}

		}
		if(unTel == 2){
			if(uService.YZTEL(getStuNo())){
				uService.alterUnTelUser(2, stuNo, userPw);
				jsonObject.put("actalResult", "Y");
			}else {
				jsonObject.put("actalResult", "N");
			} 
		}


		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonObject.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//上传用户头像
	public void activityupUserLogo(){

		User user = new User();
		user = uService.getUserInfoOther(stuNo);
		System.out.println("activityupUserLogo"+stuNo);

		String logoName = "C:\\windowsserver\\Project\\ShaiquanServer\\userLogo/" + "head_" + user.getStuNo().toString() + ".jpg";
		System.out.println(logoName);

		HttpServletRequest request = ServletActionContext.getRequest();
		File file = new File(logoName);
		try {

			ServletInputStream sis = request.getInputStream();

			//			FileInputStream fis = new FileInputStream(logoName);
			FileOutputStream fos = new FileOutputStream(file);

			byte [] b = new byte[1024];
			int len = 0;
			while((len = sis.read(b)) > 0){
				fos.write(b,0,len);
			}

			sis.close();
			fos.close();
			//			fis.close();


			uService.alterUser("head_" + user.getStuNo().toString() + ".jpg", 9, stuNo);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

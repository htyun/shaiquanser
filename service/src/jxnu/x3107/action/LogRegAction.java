package jxnu.x3107.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.Manager;
import jxnu.x3107.service.ManagerService;
import jxnu.x3107.serviceImplements.ManagerServiceImp;

public class LogRegAction extends ActionSupport{

	private Manager manager;
	private ManagerService mService = new ManagerServiceImp();

	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void validate() {
		super.validate();

		/*		if (manager.getManagerName()==null||manager.getManagerName().equals("")) {
			this.addFieldError("manager.managerName", "账号不能为空");
		}
		if (manager.getManagerPw() == null || manager.getManagerPw().equals("")) {
			this.addFieldError("manager.managerPw", "密码不能为空");
		}
		if(manager.getManagerEmail() == null || manager.getManagerEmail().equals("")){
			this.addFieldError("manager.managerEmail","邮箱不能为空");
		}
		 */
	}

	//登录
	public String loginManager(){

		String bl = "loginFa";

		if(mService.YZ(this.manager)){
			Map<String,Object> sMap = ActionContext.getContext().getSession();
			sMap.put("managerName", manager.getManagerName()+"");
			bl = "loginSu";
			return bl;
		}else{

			return bl;
		}
	}
	
	

	private File manaLogo;
	private String manaLogoFileName;//Struts2提供的格式，在文件名后+FileName就是上传文件的名字  
	private String manaLogoContentType;//文件类型
	@SuppressWarnings("unused")
	private String savePath;
	
	public File getManaLogo() {
		return manaLogo;
	}
	public void setManaLogo(File manaLogo) {
		this.manaLogo = manaLogo;
	}
	public String getManaLogoContentType() {
		return manaLogoContentType;
	}
	public void setManaLogoContentType(String manaLogoContentType) {
		this.manaLogoContentType = manaLogoContentType;
	}
	public String getManaLogoFileName() {
		return manaLogoFileName;
	}
	public void setManaLogoFileName(String manaLogoFileName) {
		this.manaLogoFileName = manaLogoFileName;
	}
	public String getSavePath() {
		return "C:\\windowsserver\\Project\\ShaiquanServer\\managerLogo/";
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	//注册
	public String regManager() throws Exception {

		String bl = "regFa";
		
		String logoName = getSavePath()+ manager.getManagerName() + "_" +getManaLogoFileName();
		
		FileOutputStream fos = new FileOutputStream(logoName);
		FileInputStream fis = new FileInputStream(getManaLogo());
		
		byte [] b = new byte[1024];
		int len = 0;
		while((len = fis.read(b)) > 0){
			fos.write(b,0,len);
		}
		
		fos.close();
		fis.close();
		
		System.out.println("上传文件名"+manaLogoFileName);  
        System.out.println("上传文件类型"+manaLogoContentType); 
        manager.setManagerLogo(logoName);
		if(mService.addManager(manager) != 0){
			
			bl = "regSu";
			System.out.println(manager.getManagerLogo()+"");
		}
		return bl;
	}









}

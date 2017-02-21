package jxnu.x3107.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//页面跳转

public class IndexAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String tzLogin(){



		return "loginSu";
	}
	public String tzReg(){



		return "regSu";
	}
	//注销
	public String zx (){

		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("managerName", "");

		return "zxS";

	}

	public String indexGetGoods(){

		String str = "getSU";

		return str;
	}

	public String indexGetUser(){
		
		String str = "getSU";

		return str;
	}

}

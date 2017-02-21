package jxnu.x3107.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.Follow;
import jxnu.x3107.bean.Goods;
import jxnu.x3107.service.FollowService;
import jxnu.x3107.service.GoodsService;
import jxnu.x3107.serviceImplements.FollowServiceImp;
import jxnu.x3107.serviceImplements.GoodsServiceImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActivityFollowAction extends ActionSupport{

	private String userID;
	private String releaserID;

	FollowService fService = new FollowServiceImp();
	HttpServletResponse response = ServletActionContext.getResponse();

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReleaserID() {
		return releaserID;
	}
	public void setReleaserID(String releaserID) {
		this.releaserID = releaserID;
	}

	public void actaddFollow(){

		int i = 0;
		
		JSONObject jsonObject = new JSONObject();
		List<Follow> fList = new ArrayList<Follow>();
		fList = fService.getFollowInfo(userID);
		if (fList != null) {
			for(i = 0; i < fList.size(); i++){
				if (fList.get(i).getReleaserID().equals(releaserID)) {
					jsonObject.put("addFollow", "N");
					return;
				}
			}
			if (i == fList.size()) {
				if (fService.addFollow(userID, releaserID) != 0) {
					jsonObject.put("addFollow", "Y");
				}else {
					jsonObject.put("addFollow", "N");
				}
			}

		}else {

			if (fService.addFollow(userID, releaserID) != 0) {
				jsonObject.put("addFollow", "Y");
			}else {
				jsonObject.put("addFollow", "N");
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

	public void actdelFollow(){
		JSONObject jsonObject = new JSONObject();
		if (fService.delFollow(releaserID) != 0) {
			jsonObject.put("delFollow", "Y");
		}else {
			jsonObject.put("delFollow", "N");
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

	public void actgetFollow(){
		List<Follow> fList = new ArrayList<Follow>();
		JSONObject jsonObject = new JSONObject();
		fList = fService.getFollowInfo(userID);
		if (fList != null) {
			JSONArray jsonArray = JSONArray.fromObject(fList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("getFollow", jsonArray);
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

	//获得关注人的物品信息
	public void actgetFollowGoods(){

		List<Goods> gList = null;
		List<Follow> fList = new ArrayList<Follow>();
		fList = fService.getFollowInfo(userID);
		GoodsService gService = new GoodsServiceImp();
		JSONObject jsonObject = new JSONObject();
		List<Goods> gListAll = new ArrayList<Goods>();
		for(int i = 0; i < fList.size(); i++){
			gList = new ArrayList<Goods>();
			gList = gService.getGoodsInfo(fList.get(i).getReleaserID());
			gListAll.addAll(gList);

		}

		if (gListAll != null) {
			JSONArray jsonArray = JSONArray.fromObject(gListAll);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("getFollowGoods", jsonArray);
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

}

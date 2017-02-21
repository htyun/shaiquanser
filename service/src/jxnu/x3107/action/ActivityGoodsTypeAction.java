package jxnu.x3107.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.Goods;
import jxnu.x3107.bean.GoodsType;
import jxnu.x3107.service.GoodsService;
import jxnu.x3107.service.GoodsTypeService;
import jxnu.x3107.serviceImplements.GoodsServiceImp;
import jxnu.x3107.serviceImplements.GoodsTypeServiceImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActivityGoodsTypeAction extends ActionSupport{

	private String userID;
	private String releaserID;
	private String releaserTime;

	GoodsTypeService gtService = new GoodsTypeServiceImp();
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
	public String getReleaserTime() {
		return releaserTime;
	}
	public void setReleaserTime(String releaserTime) {
		this.releaserTime = releaserTime;
	}

	//添加收藏
	public void actaddGoodsType(){
		int i = 0;
		List<GoodsType> gtList = new ArrayList<GoodsType>();
		gtList = gtService.getGoodsTypeInfo(userID);
		JSONObject jsonObject = new JSONObject();
		if (gtList != null) {

			for(i = 0; i < gtList.size(); i++){
				if (gtList.get(i).getReleaseTime().equals(releaserTime)) {
					jsonObject.put("addGoodsType", "N");
					return;
				}
			}
			if (i == gtList.size()) {
				if (gtService.addGoodsType(userID, releaserID, releaserTime) != 0) {

					jsonObject.put("addGoodsType", "Y");
				}
			}

		}else {
			if (gtService.addGoodsType(userID, releaserID, releaserTime) != 0) {

				jsonObject.put("addGoodsType", "Y");
			}
		}

		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonObject.toString());
			response.getWriter().flush();
			response.getWriter().close();;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//获得收藏
	public void actgetGoodsTypeInfo(){

		List<GoodsType> gtList = new ArrayList<GoodsType>();
		gtList = gtService.getGoodsTypeInfo(userID);
		GoodsService gService = new GoodsServiceImp();
		List<Goods> gList = new ArrayList<Goods>();
		JSONObject jsonObject = new JSONObject();

		for(int i = 0; i < gtList.size(); i++){
			Goods goods = new Goods();
			goods = gService.getOlGoodsInfo(gtList.get(i).getReleaserID(), gtList.get(i).getReleaseTime());
			gList.add(goods);
		}

		if (gList != null) {
			JSONArray jsonArray = JSONArray.fromObject(gList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("getGoodsTypeInfo", jsonArray);
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

	//删除收藏
	public void actdelGoodsType(){

		JSONObject jsonObject = new JSONObject();
		if (gtService.delGoodsType(releaserID, releaserTime) != 0) {
			jsonObject.put("delGoodsType", "Y");
		}else {
			jsonObject.put("delGoodsType", "N");
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

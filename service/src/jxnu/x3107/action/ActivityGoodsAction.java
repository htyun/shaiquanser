package jxnu.x3107.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.Goods;
import jxnu.x3107.service.GoodsService;
import jxnu.x3107.service.UserService;
import jxnu.x3107.serviceImplements.GoodsServiceImp;
import jxnu.x3107.serviceImplements.UserServiceImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActivityGoodsAction extends ActionSupport{

	private String goodName;
	private String goodLogo;
	private String goodIntroduction;
	private String releaseTime;
	private String fromWhere;
	private int goodState;
	private double price;
	private String fromSchoolID;
	private String releaserID;
	private String goodClassify;
	private String time;

	UserService uService = new UserServiceImp();
	GoodsService gService = new GoodsServiceImp();

	private List<Goods> gList;

	HttpServletResponse response = ServletActionContext.getResponse();


	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodLogo() {
		return goodLogo;
	}

	public void setGoodLogo(String goodLogo) {
		this.goodLogo = goodLogo;
	}

	public String getGoodIntroduction() {
		return goodIntroduction;
	}

	public void setGoodIntroduction(String goodIntroduction) {
		this.goodIntroduction = goodIntroduction;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getFromWhere() {
		return fromWhere;
	}

	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}

	public int getGoodState() {
		return goodState;
	}

	public void setGoodState(int goodState) {
		this.goodState = goodState;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFromSchoolID() {
		return fromSchoolID;
	}

	public void setFromSchoolID(String fromSchoolID) {
		this.fromSchoolID = fromSchoolID;
	}

	public String getReleaserID() {
		return releaserID;
	}

	public void setReleaserID(String releaserID) {
		this.releaserID = releaserID;
	}
	public String getGoodClassify() {
		return goodClassify;
	}
	public void setGoodClassify(String goodClassify) {
		this.goodClassify = goodClassify;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	//获取商品信息
	public void actgetGoodsInfo(){

		gList = new ArrayList<Goods>();
		JSONObject jsonObject = new JSONObject();
		gList = gService.getGoodsInfo();

		if(gList != null){
			JSONArray jsonArray = JSONArray.fromObject(gList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("allGoodsInfo", jsonArray);
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

	//获取具体商品信息
	public void actgetOlGoodsInfo(){

		Goods goods = gService.getOlGoodsInfo(goodName, releaserID,releaseTime);
		JSONObject jsonObject = new JSONObject();

		if(goods != null){

			JSONArray jsonArray = JSONArray.fromObject(goods);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("goodsOlInfo", jsonArray);
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

	//获取个人商品信息
	public void actgetIDGoodsInfo(){

		gList = new ArrayList<Goods>();
		JSONObject jsonObject = new JSONObject();
		gList = gService.getGoodsInfo(releaserID);
		if(gList != null){
			JSONArray jsonArray = JSONArray.fromObject(gList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("goodsIDInfo", jsonArray);

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
	//获取分类商品信息
	public void actgetClassGoodsInfo(){

		gList = new ArrayList<Goods>();
		JSONObject jsonObject = new JSONObject();
		gList = gService.getClassGoodsInfo(goodClassify);
		if(gList != null){
			JSONArray jsonArray = JSONArray.fromObject(gList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("getClassGoodsInfo", jsonArray);

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
	//获取搜索商品信息
	public void actgetSeekGoodsInfo(){

		gList = new ArrayList<Goods>();
		JSONObject jsonObject = new JSONObject();
		gList = gService.getSeekGoodsInfo(goodName);
		if(gList != null){
			JSONArray jsonArray = JSONArray.fromObject(gList);
			System.out.println("jsonarray:" + jsonArray.toString());
			jsonObject.put("getSeekGoodsInfo", jsonArray);

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
	//添加商品
	public void actuploadGoodsInfo(){

		JSONObject jsonObject = new JSONObject();

		String img = "goods_" + getReleaserID() + "_" + getReleaseTime() + ".jpg";

		Goods goods = new Goods();
		goods.setGoodName(getGoodName());
		goods.setGoodIntroduction(getGoodIntroduction());
		goods.setPrice( getPrice());
		goods.setGoodState(getGoodState());
		goods.setFromWhere(getFromWhere());
		goods.setReleaserID(getReleaserID());
		goods.setReleaseTime(getReleaseTime());
		goods.setGoodClassify(getGoodClassify());
		goods.setGoodLogo(img);
		goods.setTime(getTime());
		if(gService.addGoods(goods) != 0){
			jsonObject.put("uploadGoodsInfoResult", "Y");
		}else {
			jsonObject.put("uploadGoodsInfoResult", "N");
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

	//上传商品图片
	public void actupGoodsLogo(){


		String logoName = "C:\\windowsserver\\Project\\ShaiquanServer\\goodsLogo/" + "goods_" + getReleaserID() + "_" + getReleaseTime() + ".jpg";
		System.out.println(logoName);

		HttpServletRequest request = ServletActionContext.getRequest();
		File file = new File(logoName);
		try {

			ServletInputStream sis = request.getInputStream();
			FileOutputStream fos = new FileOutputStream(file);
			byte [] b = new byte[1024];
			int len = 0;
			while((len = sis.read(b)) > 0){
				fos.write(b,0,len);
			}
			sis.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//修改商品信息
	public void actaltIDGoodsInfo(){

		JSONObject jsonObject = new JSONObject();
		Goods goods = new Goods();
		goods.setGoodName(getGoodName());
		goods.setGoodIntroduction(getGoodIntroduction());
		goods.setPrice( getPrice());
		goods.setGoodClassify(getGoodClassify());
		if(gService.altGoodsInfo(goods, releaserID, releaseTime) != 0){
			jsonObject.put("altIDGoodsInfoResult", "Y");
		}else {
			jsonObject.put("altIDGoodsInfoResult", "N");
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
	//删除商品
	public void actdelIDGoodsInfo(){


		File file = new File("C:\\windowsserver\\Project\\ShaiquanServer\\goodsLogo/" + "goods_" + getReleaserID() + "_" + getReleaseTime() + ".jpg");
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
			} else {
			}
		} else {
			file.delete();
		}

		JSONObject jsonObject = new JSONObject();
		if(gService.deleteGoods(releaserID, releaseTime) != 0){
			jsonObject.put("delIDGoodsInfoResult", "Y");
		}else {
			jsonObject.put("delIDGoodsInfoResult", "N");
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

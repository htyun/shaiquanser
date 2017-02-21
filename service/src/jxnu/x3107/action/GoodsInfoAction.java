package jxnu.x3107.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jxnu.x3107.bean.Goods;
import jxnu.x3107.service.GoodsService;
import jxnu.x3107.serviceImplements.GoodsServiceImp;

public class GoodsInfoAction extends ActionSupport{

	GoodsService gService = new GoodsServiceImp();

	private List<Goods> goodsList ;
	//获取商品信息
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public String getGoodsInfo(){
		String str = "gInSU";

		goodsList = gService.getGoodsInfo();

		return str;
	}
	//删除
	private String releaseTime;
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public String delGoods(){
		String str = "deletFA";
		
		Goods goodslogo = new Goods();
		System.out.println(releaseTime);
		goodslogo = gService.getGoodsTime(releaseTime);
		System.out.println(goodslogo.getGoodLogo());
		
		File file = new File("C:\\windowsserver\\Project\\ShaiquanServer\\goodsLogo/" + goodslogo.getGoodLogo());
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
			} else {
			}
		} else {
			file.delete();
		}

		if (gService.deletGoods(releaseTime) != 0) {
			str = "deletSU";
		}

		return str;
	}

	private Goods goods;
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	//修改
	public String edits(){
		String str = "editSU";
		Map<String ,Object> session = ActionContext.getContext().getSession();
		session.put("releaseTime", getReleaseTime()+"");
		goods = gService.getGoodsTime(releaseTime);
		return str;
	}
	public String editGoods(){
		String str = "editFA";
		Map<String ,Object> session = ActionContext.getContext().getSession();
		if (gService.editGoods(goods, (String) session.get("releaseTime")) != 0) {
			str = "editSU";
		}

		return str;
	}
	//添加
	private String goodLogo;
	private String goodLogoFileName;//Struts2提供的格式，在文件名后+FileName就是上传文件的名字  
	private String goodLogoContentType;//文件类型

	public String getGoodLogo() {
		return goodLogo;
	}
	public void setGoodLogo(String goodLogo) {
		this.goodLogo = goodLogo;
	}
	public String getGoodLogoFileName() {
		return goodLogoFileName;
	}
	public void setGoodLogoFileName(String goodLogoFileName) {
		this.goodLogoFileName = goodLogoFileName;
	}
	public String getGoodLogoContentType() {
		return goodLogoContentType;
	}
	public void setGoodLogoContentType(String goodLogoContentType) {
		this.goodLogoContentType = goodLogoContentType;
	}
	public String insertGoods(){
		String str = "insFA";

		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");//yyyy-MM-dd 
		SimpleDateFormat formatTime = new SimpleDateFormat("yy-MM-dd-HH:mm:ss");//yyyy-MM-dd 
		String strformat;
		String strformatTime;
		
		strformat = format.format(new java.util.Date());
		strformatTime = formatTime.format(new java.util.Date());

		String logoName = "C:\\windowsserver\\Project\\ShaiquanServer\\goodsLogo/goods_" + goods.getReleaserID() + "_" + strformat +".jpg";
		try {
			FileOutputStream fos = new FileOutputStream(logoName);
			FileInputStream fis = new FileInputStream(getGoodLogo());
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

		goods.setGoodLogo("goods_" + goods.getReleaserID() + "_" + strformat +".jpg");
		goods.setTime(strformatTime);
		goods.setReleaseTime(strformat);
		if (gService.insertGoods(goods) != 0) {
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
	public String goodsByPage(){
		String str = "pageF";

		recordsize =  gService.getRecordSize();
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

		goodsList = gService.getGoodsListByPage(pageNow, pageSize);
		if (goodsList.size() != 0) {
			str = "pageSU";
		}

		return str;
	}


}

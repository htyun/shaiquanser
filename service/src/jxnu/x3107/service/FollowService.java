package jxnu.x3107.service;

import java.util.List;

import jxnu.x3107.bean.Follow;

public interface FollowService {

//			select * from followTable where userID='12'
	public List<Follow> getFollowInfo(String userID);//查询
//			insert into followTable (userID,releaserID) values ('12','123')
	public int addFollow(String userID,String releaserID);//添加
//			delete from followTable where releaserID='123'
	public int delFollow(String releaserID);//删除

}

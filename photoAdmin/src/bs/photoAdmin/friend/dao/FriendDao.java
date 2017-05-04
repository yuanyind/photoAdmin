package bs.photoAdmin.friend.dao;

import java.util.List;

import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.UserInfo;

public interface FriendDao {
	//添加好友
	public void addFriend(FriendInfo friendInfo);
	//删除好友
	public void deleteFriend(FriendInfo friendInfo);
	//更新好友
	public void updateFriend(FriendInfo friendInfo);
	//更新好友
	public void updateFriend2(FriendInfo friendInfo);
	//显示所有好友
	public List<FriendInfo> listAllFriend(UserInfo userInfo);
	//查找好友byfid
	public FriendInfo queryFriendById(int fId);
	//查找好友byUser
	public FriendInfo queryFriendByUser(UserInfo selfUser, UserInfo otherUser);
	//显示好友by分组
	public List<FriendInfo> queryByFgid(FgroupInfo fgInfo);
	//添加好友分组
	public void addFgroup(FgroupInfo fgInfo);
	//删除好友分组
	public void deleteFgroup(FgroupInfo fgInfo);
	//更新好友分组
	public void updateFgroup(FgroupInfo fgroupInfo,Integer fgId);
	//显示好友分组
	public List<FgroupInfo> listAllFgroup(UserInfo userInfo);
	//查找好友分组
	public FgroupInfo queryFgroupById(int fgId);
	//获得用户初始化分组的id
	public FgroupInfo getIniFgId(UserInfo userInfo);
	
}

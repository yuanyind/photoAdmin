package bs.photoAdmin.friend.service;

import java.util.List;

import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.UserInfo;

public interface FriendService {
		//添加好友
		public boolean addFriend(UserInfo u, int otherFid);
		//确认好友分组
		public boolean verifyMsg(UserInfo u,int otherFid, FgroupInfo fgInfo, String verify);
		//通过验证，选择分组
		public boolean chooseFgroup(FriendInfo friendInfo, FgroupInfo fgroupInfo);
		//查找好友byFid
		public FriendInfo queryByFid(Integer fid);
		//删除好友
		public boolean deleteFriend(UserInfo userInfo, UserInfo otherUserInfo);
		//更新好友
		public boolean updateFriend(FriendInfo friendInfo);
		//显示所有好友
		public List<FriendInfo> listAllFriend(UserInfo u);
		//显示好友by分组
		public List<FriendInfo> queryByFgid(FgroupInfo fgInfo);
		//添加好友分组
		public boolean addFgroup(FgroupInfo fgInfo);
		//删除好友分组
		public boolean deleteFgroup(UserInfo userInfo, int[] fgs);
		//显示好友分组
		public List<FgroupInfo> listAllFgroup(UserInfo u);
		//查询好友分组
		public FgroupInfo queryFgroupById(int fgId);
		//验证是否为好友
		public Integer verifyIfFriend(UserInfo selfUser, UserInfo otherUser);
		
}

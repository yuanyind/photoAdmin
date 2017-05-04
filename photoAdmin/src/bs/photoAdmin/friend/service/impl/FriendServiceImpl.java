package bs.photoAdmin.friend.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Action;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import bs.photoAdmin.friend.dao.FriendDao;
import bs.photoAdmin.friend.service.FriendService;
import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.msg.dao.MsgDao;
import bs.photoAdmin.user.dao.UserDao;


public class FriendServiceImpl implements FriendService {
			
	private FriendDao friendDao;
	private UserDao userDao;
	private MsgDao msgDao;

	
	
	public FriendDao getFriendDao() {
		return friendDao;
	}
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public MsgDao getMsgDao() {
		return msgDao;
	}
	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}
	//添加好友
	public boolean addFriend(UserInfo u, int otherFid){
		try{
			
			UserInfo otherUser=userDao.queryById(otherFid);
			
			FriendInfo friendInfoSelf=new FriendInfo();
			FriendInfo friendInfoOther=new FriendInfo();
			
			FgroupInfo otherFg=friendDao.getIniFgId(otherUser);
			
			System.out.print("\nwhy1");
			friendDao.addFriend(friendInfoSelf);
			friendDao.addFriend(friendInfoOther);
			System.out.print("\nwhy2");
			friendInfoSelf.setUserInfoBySelfuserId(u);
			friendInfoSelf.setUserInfoByOtheruserId(otherUser);
			friendInfoSelf.setFgIsPass(false);
			
			friendInfoOther.setUserInfoBySelfuserId(otherUser);
			friendInfoOther.setUserInfoByOtheruserId(u);
			friendInfoOther.setFgIsPass(false);
			friendInfoOther.setFgroupInfo(otherFg);
			
			friendDao.updateFriend2(friendInfoSelf);
			friendDao.updateFriend2(friendInfoOther);
			System.out.print("\nwhy5");
			MsgInfo msgInfo = new MsgInfo();
			msgDao.addMsg(msgInfo);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			
			msgInfo.setUserInfoByMsgFromUserId(u);
			msgInfo.setUserInfoByMsgToUserId(otherUser);
			msgInfo.setMsgCreatetime(time);
			msgInfo.setMsgFlag(true);
			msgDao.updateMsg(msgInfo);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	//确认好友分组
	public boolean verifyMsg(UserInfo u,int otherFid, FgroupInfo fgInfo, String verify){
		try{
			System.out.print("\nits's service");
			UserInfo otherUser=userDao.queryById(otherFid);
			
			FriendInfo friendInfo=friendDao.queryFriendByUser(u, otherUser);
			
			friendInfo.setFgroupInfo(fgInfo);
			friendDao.updateFriend(friendInfo);
			
			
			UserInfo fromUser=friendInfo.getUserInfoBySelfuserId();
			
			UserInfo toUser=friendInfo.getUserInfoByOtheruserId();
			
			
			MsgInfo msgInfo=msgDao.queryMsgByUser(fromUser, toUser);
			
			msgInfo.setMsgVerify(verify);
			
			msgDao.updateMsg2(msgInfo);
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//通过验证，选择分组
	public boolean chooseFgroup(FriendInfo friendInfo, FgroupInfo fgroupInfo){
		try{
			FgroupInfo fgBefore=friendInfo.getFgroupInfo();
			friendDao.updateFgroup(fgBefore, friendDao.queryByFgid(fgBefore).size()-1);
			
			friendInfo.setFgroupInfo(fgroupInfo);
			friendDao.updateFriend(friendInfo);
			
			friendDao.updateFgroup(fgroupInfo, friendDao.queryByFgid(fgroupInfo).size()+1);
			
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//查找好友byFid
	public FriendInfo queryByFid(Integer fid){
		return friendDao.queryFriendById(fid);
	}
	//删除好友
	public boolean deleteFriend(UserInfo userInfo, UserInfo otherUserInfo){
		try{
			FriendInfo friendInfo=friendDao.queryFriendByUser(userInfo, otherUserInfo);							
			
			FriendInfo otherFriendInfo=friendDao.queryFriendByUser(friendInfo.getUserInfoByOtheruserId(), friendInfo.getUserInfoBySelfuserId());
			System.out.print(friendInfo.getFId());
			System.out.print(otherFriendInfo.getFId());
			friendDao.deleteFriend(friendInfo);
			friendDao.deleteFriend(otherFriendInfo);
		
	}catch(Exception e){
		return false;
	}
	return true;
	}
	
	//更新好友
	public boolean updateFriend(FriendInfo friendInfo){
		try{
			friendDao.updateFriend(friendInfo);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//显示所有好友
	public List<FriendInfo> listAllFriend(UserInfo u){
		List<FgroupInfo> fgs=friendDao.listAllFgroup(u);
		for(int i=0;i<fgs.size();i++){
			System.out.print("/ni:"+friendDao.queryByFgid(fgs.get(i)).size());
			friendDao.updateFgroup(fgs.get(i),friendDao.queryByFgid(fgs.get(i)).size());
		}
		return friendDao.listAllFriend(u);
	}
	//显示好友by分组
	public List<FriendInfo> queryByFgid(FgroupInfo fgInfo){
		
		return friendDao.queryByFgid(fgInfo);
	}
	//添加好友分组
	public boolean addFgroup(FgroupInfo fgInfo){
		try{
			friendDao.addFgroup(fgInfo);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//删除好友分组
	public boolean deleteFgroup(UserInfo userInfo,int[] fgs){
		try{
			FgroupInfo fgIni =friendDao.getIniFgId(userInfo); //获得初始化groupId
			for(int i=0;i<fgs.length;i++){
				System.out.print("ser1\n");
				FgroupInfo fgInfo = friendDao.queryFgroupById(fgs[i]);
				List<FriendInfo> fs = friendDao.queryByFgid(fgInfo);
				for(int j=0;j<fs.size();j++){
					FriendInfo friendInfo = friendDao.queryFriendById(fs.get(j).getFId());
					friendInfo.setFgroupInfo(fgIni);
					friendDao.updateFriend(friendInfo);
				}
				friendDao.updateFgroup(fgIni,(fgIni.getFgNumber()+fs.size()));
				friendDao.deleteFgroup(fgInfo);
				System.out.print("ser3\n");
			}
		}catch(Exception e){
			System.out.print("serf\n");
			return false;
		}
		return true;
	}
	
	
	//显示好友分组
	public List<FgroupInfo> listAllFgroup(UserInfo u){
		return friendDao.listAllFgroup(u);
	}
	//查询好友分组
	public FgroupInfo queryFgroupById(int fgId){
		System.out.print(fgId);
		return friendDao.queryFgroupById(fgId);
	}
	
	//验证是否为好友
	public Integer verifyIfFriend(UserInfo selfUser, UserInfo otherUser){
		if(friendDao.queryFriendByUser(selfUser, otherUser)!=null){
			if(friendDao.queryFriendByUser(selfUser, otherUser).getFgIsPass()){
				return 1;	//已通过验证的好友关系
			}else{
				return 0;	//待验证的好友关系
			}
		}else{
			return 2;	//非好友关系
		}
	}
}

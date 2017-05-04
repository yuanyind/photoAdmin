package bs.photoAdmin.msg.service.impl;

import java.sql.Timestamp;
import java.util.List;

import bs.photoAdmin.friend.dao.FriendDao;
import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.msg.dao.MsgDao;
import bs.photoAdmin.msg.service.MsgService;

public class MsgServiceImpl implements MsgService {
	private MsgDao msgDao;
	private FriendDao friendDao;
	
	public MsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}

	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	//所收消息列表
	public List<MsgInfo> listRecverMsg(UserInfo u, boolean flag){
		return msgDao.listMsgByRecver(u,flag);
	}
	//查询消息byID
	public MsgInfo queryMsgById(Integer id){
		return msgDao.queryMsgById(id);
	}
	//同意添加好友
	public boolean agreeToAdd(MsgInfo msg){
		try{
			
			UserInfo msgFromUser= msg.getUserInfoByMsgFromUserId();
			
			UserInfo msgToUser=msg.getUserInfoByMsgToUserId();
			//修改friend的pass状态通过
			FriendInfo friendInfo1=friendDao.queryFriendByUser(msgFromUser, msgToUser);
			FriendInfo friendInfo2=friendDao.queryFriendByUser(msgToUser, msgFromUser);
			friendInfo1.setFgIsPass(true);
			friendInfo2.setFgIsPass(true);
			
			friendDao.updateFriend(friendInfo1);
			friendDao.updateFriend(friendInfo2);
			
			//修改好友分组数量
			FgroupInfo fg1=friendInfo1.getFgroupInfo();
			FgroupInfo fg2=friendInfo2.getFgroupInfo();
			Integer fg1N=friendDao.queryByFgid(fg1).size()+1;
			Integer fg2N=friendDao.queryByFgid(fg2).size()+1;
			friendDao.updateFgroup(fg1,fg1N);
			friendDao.updateFgroup(fg2,fg2N);
			System.out.print("\nthis is update fgnumber-update:");
			//添加成功通知回执
		
			MsgInfo replyMsg = new MsgInfo();

			msgDao.addMsg(replyMsg);
			replyMsg.setUserInfoByMsgFromUserId(msgToUser);
			replyMsg.setUserInfoByMsgToUserId(msgFromUser);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			replyMsg.setMsgCreatetime(time);
			replyMsg.setMsgFlag(false);
			msgDao.updateMsg2(replyMsg);
			
			//删除添加好友的消息
			msgDao.deleteMsg(msg);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//不同意添加好友
	public boolean disagreeToAdd(MsgInfo msg){
		try{
			//得到msgInfo
			UserInfo msgFromUser= msg.getUserInfoByMsgFromUserId();
			UserInfo msgToUser=msg.getUserInfoByMsgToUserId();
			
			msg=msgDao.queryMsgByUser(msgFromUser, msgToUser);
			
			//修改friend的pass状态不通过，删除好友关系
			FriendInfo friendInfo1=friendDao.queryFriendByUser(msgFromUser, msgToUser);
			FriendInfo friendInfo2=friendDao.queryFriendByUser(msgToUser, msgFromUser);
			
			friendDao.deleteFriend(friendInfo1);
			friendDao.deleteFriend(friendInfo2);
			
			//删除添加好友的消息
			msgDao.deleteMsg(msg);
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//删除消息
	public boolean deleteMsg(MsgInfo msg){
		msgDao.deleteMsg(msg);
		return true;
	}
	
	//所收通知列表
	public List<NoticeInfo> listReceverNotice(UserInfo u, boolean flag){
		return msgDao.listNoticByRecver(u, flag);
	}
	//获得通知
	public NoticeInfo queryNoticeById(Integer id){
		return msgDao.queryNoticeById(id);
	}
	//删除通知
	public boolean deleteNotice(Integer id){
		NoticeInfo notice=msgDao.queryNoticeById(id);
		msgDao.deleteNotice(notice);
		return true;
	}
}

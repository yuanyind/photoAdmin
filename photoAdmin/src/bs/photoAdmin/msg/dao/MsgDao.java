package bs.photoAdmin.msg.dao;

import java.util.List;

import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.UserInfo;

public interface MsgDao {

	//添加好友消息
	public void addMsg(MsgInfo msgInfo);
	//消息列表byRecver
	public List<MsgInfo> listMsgByRecver(UserInfo u,boolean flag);
	//消息列表bySender
	public List<MsgInfo> listMsgBySender(UserInfo u);
	//查找消息byId
	public MsgInfo queryMsgById(Integer id);
	//删除消息
	public void deleteMsg(MsgInfo msgInfo);
	//更新消息
	public void updateMsg(MsgInfo msgInfo);
	//更新消息
	public void updateMsg2(MsgInfo msgInfo);
	//查找消息byUser
	public MsgInfo queryMsgByUser(UserInfo fromUser, UserInfo toUser);
	
	
	//添加通知
	public void addNotice(NoticeInfo noticeInfo);
	//通知列表byRecever
	public List<NoticeInfo> listNoticByRecver(UserInfo u,boolean flag);
	//删除通知
	public void deleteNotice(NoticeInfo notice);
	//查找通知byId
	public NoticeInfo queryNoticeById(Integer id);
}

package bs.photoAdmin.msg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.UserInfo;

public interface MsgService {
	//所收消息列表
	public List<MsgInfo> listRecverMsg(UserInfo u, boolean flag);
	//查询消息byID
	public MsgInfo queryMsgById(Integer id);
	//同意添加好友
	public boolean agreeToAdd(MsgInfo msg);
	//不同意添加好友
	public boolean disagreeToAdd(MsgInfo msg);
	//删除消息
	public boolean deleteMsg(MsgInfo msg);
	
	//所收通知列表
	public List<NoticeInfo> listReceverNotice(UserInfo u, boolean flag);
	//获得通知
	public NoticeInfo queryNoticeById(Integer id);
	//删除通知
	public boolean deleteNotice(Integer id);
}

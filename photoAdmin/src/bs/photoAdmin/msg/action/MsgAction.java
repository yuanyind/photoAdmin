package bs.photoAdmin.msg.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.msg.service.MsgService;
import bs.photoAdmin.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;



public class MsgAction {

	private MsgService msgService;
	private MsgInfo msgInfo;
	private UserService userService;
	
	private Map<String, Object> request;
	private Map<String,Object> session;
	
	public MsgService getMsgService() {
		return msgService;
	}
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}
	public MsgInfo getMsgInfo() {
		return msgInfo;
	}
	public void setMsgInfo(MsgInfo msgInfo) {
		this.msgInfo = msgInfo;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//消息列表byRecver
	public String listMsgRecver(){
		//添加好友相关消息
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		
		//主页信息
		UsericonInfo iconInfo=userService.queryIconByUser(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons",iconInfo);
		
		
		Integer countMsg=msgService.listRecverMsg(u, true).size()+msgService.listRecverMsg(u, false).size()
						+msgService.listReceverNotice(u, false).size();
		request=(Map)ActionContext.getContext().get("request");
		request.put("count",countMsg);
		
		return "showRecvMsgs";
	}
	//消息列表
	public String listNewMsg(){
		//添加好友相关消息
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<MsgInfo> list1=msgService.listRecverMsg(u,true);
		List<MsgInfo> list2=msgService.listRecverMsg(u,false);
		request=(Map)ActionContext.getContext().get("request");
		request.put("msgs1",list1);
		request.put("msgs2",list2);
		
		//评论相关消息
		List<NoticeInfo> list3=msgService.listReceverNotice(u, false);
		request=(Map)ActionContext.getContext().get("request");
		request.put("notice",list3);
		
		return "showNewMsg";
	}
	
	//同意添加好友
	public String agreeToAdd(){
		
		MsgInfo msg=msgService.queryMsgById(msgInfo.getMsgId());
	
		boolean flag=msgService.agreeToAdd(msg);
		if(flag){
			return "success";
		}else{
			return "default";
		}
	}
	
	//不同意添加好友
	public String disagreeToAdd(){
		
		MsgInfo msg=msgService.queryMsgById(msgInfo.getMsgId());
		System.out.print(msg.getUserInfoByMsgFromUserId().getUserName());
		boolean flag=msgService.disagreeToAdd(msg);
		if(flag){
			return "success";
		}else{
			return "default";
		}
	}
	//删除消息
	public String deleteMsg(){
		System.out.print("id:");
		System.out.print(msgInfo.getMsgId());
		MsgInfo msg=msgService.queryMsgById(msgInfo.getMsgId());
		boolean flag=msgService.deleteMsg(msg);
		if(flag){
			return listMsgRecver();
		}else{
			return "default";
		}
	}
	
}

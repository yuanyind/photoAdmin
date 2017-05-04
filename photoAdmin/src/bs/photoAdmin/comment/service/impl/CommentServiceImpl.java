package bs.photoAdmin.comment.service.impl;

import bs.photoAdmin.comment.dao.CommentDao;
import bs.photoAdmin.comment.service.CommentService;
import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.msg.dao.MsgDao;
import bs.photoAdmin.user.dao.UserDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Action;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

public class CommentServiceImpl implements CommentService {
	private UserDao userDao;
	private CommentDao commentDao;
	private MsgDao msgDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public MsgDao getMsgDao() {
		return msgDao;
	}
	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}
	
	//添加评论
	public  boolean addComment(UserInfo u, Integer otherFid, String commentTxt, PhotoInfo photoInfo){
		try{
			CommentInfo commentInfo=new CommentInfo();
			NoticeInfo noticeInfoToUser=new NoticeInfo();		//新建通知to回复对象
			
			
			Timestamp time = new Timestamp(System.currentTimeMillis());
			commentInfo.setCommentCreateTime(time);
			commentInfo.setUserInfoByCommentFromUserid(u);
			if(otherFid!=null){
				UserInfo otherUser=userDao.queryById(otherFid);
				commentInfo.setUserInfoByCommentToUserId(otherUser);
				noticeInfoToUser.setUserInfoByUserToUserId(otherUser);
				noticeInfoToUser.setFlag(false);	//设置消息状态未读
				noticeInfoToUser.setNoticeContent(commentTxt); 		//设置消息内容
				noticeInfoToUser.setNoticeCreatetime(time);
				noticeInfoToUser.setPhotoInfo(photoInfo);
				noticeInfoToUser.setUserInfoByUserFromUserId(u);
				msgDao.addNotice(noticeInfoToUser);
			}else{
				if(!(u.getUserId().equals(photoInfo.getUserInfo().getUserId()))){
				noticeInfoToUser.setUserInfoByUserToUserId(photoInfo.getUserInfo());
				noticeInfoToUser.setFlag(false);	//设置消息状态未读
				noticeInfoToUser.setNoticeContent(commentTxt); 		//设置消息内容
				noticeInfoToUser.setNoticeCreatetime(time);
				noticeInfoToUser.setPhotoInfo(photoInfo);
				noticeInfoToUser.setUserInfoByUserFromUserId(u);
				msgDao.addNotice(noticeInfoToUser);
				}
			}
			commentInfo.setCommentContent(commentTxt);
			commentInfo.setPhotoInfo(photoInfo);
			commentDao.addComment(commentInfo);
			
			
			
			
			if(otherFid!=null){
				if(!(otherFid.equals(photoInfo.getUserInfo().getUserId()))){
					if(!(u.getUserId().equals(photoInfo.getUserInfo().getUserId()))){
						
						NoticeInfo noticeInfoToOnwer=new NoticeInfo();		//新建通知to相片上传人
						noticeInfoToOnwer.setFlag(false);	//设置消息状态未读
						noticeInfoToOnwer.setNoticeContent(commentTxt); 		//设置消息内容
						noticeInfoToOnwer.setNoticeCreatetime(time);
						noticeInfoToOnwer.setPhotoInfo(photoInfo);
						noticeInfoToOnwer.setUserInfoByUserFromUserId(u);
						noticeInfoToOnwer.setUserInfoByUserToUserId(photoInfo.getUserInfo());
						msgDao.addNotice(noticeInfoToOnwer);
					}
				}
			}
			
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//显示评论
	public List<CommentInfo> listComment(PhotoInfo photoInfo){
		return commentDao.listCommentOfPhoto(photoInfo);
	}
}

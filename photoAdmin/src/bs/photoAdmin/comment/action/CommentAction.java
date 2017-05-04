package bs.photoAdmin.comment.action;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.comment.service.CommentService;
import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.photo.service.PhotoService;

import com.opensymphony.xwork2.ActionContext;

public class CommentAction {
	private CommentInfo commentInfo;
	private CommentService commentService;

	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	
	public CommentInfo getCommentInfo() {
		return commentInfo;
	}
	public void setCommentInfo(CommentInfo commentInfo) {
		this.commentInfo = commentInfo;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	
}

package bs.photoAdmin.comment.service;

import java.util.List;

import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;

public interface CommentService {
	//添加评论
	public  boolean addComment(UserInfo u, Integer otherFid, String commentTxt,PhotoInfo photoInfo);
	//显示评论
	public List<CommentInfo> listComment(PhotoInfo photoInfo);
}

package bs.photoAdmin.comment.dao;

import java.util.List;

import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.PhotoInfo;

public interface CommentDao {
	//添加评论
	public void addComment(CommentInfo commentInfo);
	//删除评论
	public void deleteComment(CommentInfo commentInfo);
	//显示图片相关评论
	public List<CommentInfo> listCommentOfPhoto(PhotoInfo photoInfo);
	
}

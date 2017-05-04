package bs.photoAdmin.model;

// Generated 2015-3-18 15:24:14 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * CommentInfo generated by hbm2java
 */
public class CommentInfo implements java.io.Serializable {

	private Integer commentId;
	private UserInfo userInfoByCommentFromUserid;
	private PhotoInfo photoInfo;
	private UserInfo userInfoByCommentToUserId;
	private Date commentCreateTime;
	private String commentContent;

	public CommentInfo() {
	}

	public CommentInfo(UserInfo userInfoByCommentFromUserid,
			PhotoInfo photoInfo, UserInfo userInfoByCommentToUserId,
			Date commentCreateTime, String commentContent) {
		this.userInfoByCommentFromUserid = userInfoByCommentFromUserid;
		this.photoInfo = photoInfo;
		this.userInfoByCommentToUserId = userInfoByCommentToUserId;
		this.commentCreateTime = commentCreateTime;
		this.commentContent = commentContent;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public UserInfo getUserInfoByCommentFromUserid() {
		return this.userInfoByCommentFromUserid;
	}

	public void setUserInfoByCommentFromUserid(
			UserInfo userInfoByCommentFromUserid) {
		this.userInfoByCommentFromUserid = userInfoByCommentFromUserid;
	}

	public PhotoInfo getPhotoInfo() {
		return this.photoInfo;
	}

	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}

	public UserInfo getUserInfoByCommentToUserId() {
		return this.userInfoByCommentToUserId;
	}

	public void setUserInfoByCommentToUserId(UserInfo userInfoByCommentToUserId) {
		this.userInfoByCommentToUserId = userInfoByCommentToUserId;
	}

	public Date getCommentCreateTime() {
		return this.commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

}
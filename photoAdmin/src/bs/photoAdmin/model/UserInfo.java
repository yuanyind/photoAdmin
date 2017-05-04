package bs.photoAdmin.model;

// Generated 2015-3-18 15:24:14 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo generated by hbm2java
 */
public class UserInfo implements java.io.Serializable {

	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Date userCreatetime;
	private String userGender;
	private String userIconid;
	private String userNickname;
	private String userProvince;
	private String userPhone;
	private String userCity;
	private Set commentInfosForCommentToUserId = new HashSet(0);
	private Set usericonInfos = new HashSet(0);
	private Set friendInfosForOtheruserId = new HashSet(0);
	private Set userHasAlbumInfos = new HashSet(0);
	private Set friendInfosForSelfuserId = new HashSet(0);
	private Set tagInfos = new HashSet(0);
	private Set downloadInfos = new HashSet(0);
	private Set fgroupInfos = new HashSet(0);
	private Set noticeInfosForUserToUserId = new HashSet(0);
	private Set commentInfosForCommentFromUserid = new HashSet(0);
	private Set photoInfos = new HashSet(0);
	private Set noticeInfosForUserFromUserId = new HashSet(0);
	private Set albumInfos = new HashSet(0);
	private Set msgInfosForMsgToUserId = new HashSet(0);
	private Set msgInfosForMsgFromUserId = new HashSet(0);

	public UserInfo() {
	}

	public UserInfo(String userName, String userPassword, String userNickname) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
	}

	public UserInfo(String userName, String userEmail, String userPassword,
			Date userCreatetime, String userGender, String userIconid,
			String userNickname, String userProvince, String userPhone,
			String userCity, Set commentInfosForCommentToUserId,
			Set usericonInfos, Set friendInfosForOtheruserId,
			Set userHasAlbumInfos, Set friendInfosForSelfuserId, Set tagInfos,
			Set downloadInfos, Set fgroupInfos, Set noticeInfosForUserToUserId,
			Set commentInfosForCommentFromUserid, Set photoInfos,
			Set noticeInfosForUserFromUserId, Set albumInfos,
			Set msgInfosForMsgToUserId, Set msgInfosForMsgFromUserId) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userCreatetime = userCreatetime;
		this.userGender = userGender;
		this.userIconid = userIconid;
		this.userNickname = userNickname;
		this.userProvince = userProvince;
		this.userPhone = userPhone;
		this.userCity = userCity;
		this.commentInfosForCommentToUserId = commentInfosForCommentToUserId;
		this.usericonInfos = usericonInfos;
		this.friendInfosForOtheruserId = friendInfosForOtheruserId;
		this.userHasAlbumInfos = userHasAlbumInfos;
		this.friendInfosForSelfuserId = friendInfosForSelfuserId;
		this.tagInfos = tagInfos;
		this.downloadInfos = downloadInfos;
		this.fgroupInfos = fgroupInfos;
		this.noticeInfosForUserToUserId = noticeInfosForUserToUserId;
		this.commentInfosForCommentFromUserid = commentInfosForCommentFromUserid;
		this.photoInfos = photoInfos;
		this.noticeInfosForUserFromUserId = noticeInfosForUserFromUserId;
		this.albumInfos = albumInfos;
		this.msgInfosForMsgToUserId = msgInfosForMsgToUserId;
		this.msgInfosForMsgFromUserId = msgInfosForMsgFromUserId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserCreatetime() {
		return this.userCreatetime;
	}

	public void setUserCreatetime(Date userCreatetime) {
		this.userCreatetime = userCreatetime;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserIconid() {
		return this.userIconid;
	}

	public void setUserIconid(String userIconid) {
		this.userIconid = userIconid;
	}

	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserProvince() {
		return this.userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public Set getCommentInfosForCommentToUserId() {
		return this.commentInfosForCommentToUserId;
	}

	public void setCommentInfosForCommentToUserId(
			Set commentInfosForCommentToUserId) {
		this.commentInfosForCommentToUserId = commentInfosForCommentToUserId;
	}

	public Set getUsericonInfos() {
		return this.usericonInfos;
	}

	public void setUsericonInfos(Set usericonInfos) {
		this.usericonInfos = usericonInfos;
	}

	public Set getFriendInfosForOtheruserId() {
		return this.friendInfosForOtheruserId;
	}

	public void setFriendInfosForOtheruserId(Set friendInfosForOtheruserId) {
		this.friendInfosForOtheruserId = friendInfosForOtheruserId;
	}

	public Set getUserHasAlbumInfos() {
		return this.userHasAlbumInfos;
	}

	public void setUserHasAlbumInfos(Set userHasAlbumInfos) {
		this.userHasAlbumInfos = userHasAlbumInfos;
	}

	public Set getFriendInfosForSelfuserId() {
		return this.friendInfosForSelfuserId;
	}

	public void setFriendInfosForSelfuserId(Set friendInfosForSelfuserId) {
		this.friendInfosForSelfuserId = friendInfosForSelfuserId;
	}

	public Set getTagInfos() {
		return this.tagInfos;
	}

	public void setTagInfos(Set tagInfos) {
		this.tagInfos = tagInfos;
	}

	public Set getDownloadInfos() {
		return this.downloadInfos;
	}

	public void setDownloadInfos(Set downloadInfos) {
		this.downloadInfos = downloadInfos;
	}

	public Set getFgroupInfos() {
		return this.fgroupInfos;
	}

	public void setFgroupInfos(Set fgroupInfos) {
		this.fgroupInfos = fgroupInfos;
	}

	public Set getNoticeInfosForUserToUserId() {
		return this.noticeInfosForUserToUserId;
	}

	public void setNoticeInfosForUserToUserId(Set noticeInfosForUserToUserId) {
		this.noticeInfosForUserToUserId = noticeInfosForUserToUserId;
	}

	public Set getCommentInfosForCommentFromUserid() {
		return this.commentInfosForCommentFromUserid;
	}

	public void setCommentInfosForCommentFromUserid(
			Set commentInfosForCommentFromUserid) {
		this.commentInfosForCommentFromUserid = commentInfosForCommentFromUserid;
	}

	public Set getPhotoInfos() {
		return this.photoInfos;
	}

	public void setPhotoInfos(Set photoInfos) {
		this.photoInfos = photoInfos;
	}

	public Set getNoticeInfosForUserFromUserId() {
		return this.noticeInfosForUserFromUserId;
	}

	public void setNoticeInfosForUserFromUserId(Set noticeInfosForUserFromUserId) {
		this.noticeInfosForUserFromUserId = noticeInfosForUserFromUserId;
	}

	public Set getAlbumInfos() {
		return this.albumInfos;
	}

	public void setAlbumInfos(Set albumInfos) {
		this.albumInfos = albumInfos;
	}

	public Set getMsgInfosForMsgToUserId() {
		return this.msgInfosForMsgToUserId;
	}

	public void setMsgInfosForMsgToUserId(Set msgInfosForMsgToUserId) {
		this.msgInfosForMsgToUserId = msgInfosForMsgToUserId;
	}

	public Set getMsgInfosForMsgFromUserId() {
		return this.msgInfosForMsgFromUserId;
	}

	public void setMsgInfosForMsgFromUserId(Set msgInfosForMsgFromUserId) {
		this.msgInfosForMsgFromUserId = msgInfosForMsgFromUserId;
	}

}

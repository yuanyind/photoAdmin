package bs.photoAdmin.model;

// Generated 2015-3-18 15:24:14 by Hibernate Tools 3.4.0.CR1

/**
 * FriendInfo generated by hbm2java
 */
public class FriendInfo implements java.io.Serializable {

	private Integer FId;
	private UserInfo userInfoBySelfuserId;
	private FgroupInfo fgroupInfo;
	private UserInfo userInfoByOtheruserId;
	private Boolean fgIsPass;

	public FriendInfo() {
	}

	public FriendInfo(UserInfo userInfoBySelfuserId, FgroupInfo fgroupInfo,
			UserInfo userInfoByOtheruserId, Boolean fgIsPass) {
		this.userInfoBySelfuserId = userInfoBySelfuserId;
		this.fgroupInfo = fgroupInfo;
		this.userInfoByOtheruserId = userInfoByOtheruserId;
		this.fgIsPass = fgIsPass;
	}

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public UserInfo getUserInfoBySelfuserId() {
		return this.userInfoBySelfuserId;
	}

	public void setUserInfoBySelfuserId(UserInfo userInfoBySelfuserId) {
		this.userInfoBySelfuserId = userInfoBySelfuserId;
	}

	public FgroupInfo getFgroupInfo() {
		return this.fgroupInfo;
	}

	public void setFgroupInfo(FgroupInfo fgroupInfo) {
		this.fgroupInfo = fgroupInfo;
	}

	public UserInfo getUserInfoByOtheruserId() {
		return this.userInfoByOtheruserId;
	}

	public void setUserInfoByOtheruserId(UserInfo userInfoByOtheruserId) {
		this.userInfoByOtheruserId = userInfoByOtheruserId;
	}

	public Boolean getFgIsPass() {
		return this.fgIsPass;
	}

	public void setFgIsPass(Boolean fgIsPass) {
		this.fgIsPass = fgIsPass;
	}

}
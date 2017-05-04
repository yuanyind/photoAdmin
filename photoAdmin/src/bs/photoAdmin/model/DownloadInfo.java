package bs.photoAdmin.model;

// Generated 2015-3-18 15:24:14 by Hibernate Tools 3.4.0.CR1

/**
 * DownloadInfo generated by hbm2java
 */
public class DownloadInfo implements java.io.Serializable {

	private int downloadId;
	private UserInfo userInfo;
	private PhotoInfo photoInfo;

	public DownloadInfo() {
	}

	public DownloadInfo(int downloadId) {
		this.downloadId = downloadId;
	}

	public DownloadInfo(int downloadId, UserInfo userInfo, PhotoInfo photoInfo) {
		this.downloadId = downloadId;
		this.userInfo = userInfo;
		this.photoInfo = photoInfo;
	}

	public int getDownloadId() {
		return this.downloadId;
	}

	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public PhotoInfo getPhotoInfo() {
		return this.photoInfo;
	}

	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}

}
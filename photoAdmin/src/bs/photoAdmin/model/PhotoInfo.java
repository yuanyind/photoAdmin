package bs.photoAdmin.model;

// Generated 2015-3-18 15:24:14 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PhotoInfo generated by hbm2java
 */
public class PhotoInfo implements java.io.Serializable {

	private Integer PId;
	private AlbumInfo albumInfo;
	private UserInfo userInfo;
	private TagInfo tagInfo;
	private String PDes;
	private Float PLoclat;
	private Float PLoclng;
	private Date PCreatetime;
	private String PPath;
	private Integer PDownnum;
	private Integer PLikenum;
	private Boolean PIfmodify;
	private Integer PMainc1;
	private Float PMainc1p;
	private Integer PMainc2;
	private Float PMainc2p;
	private Set noticeInfos = new HashSet(0);
	private Set commentInfos = new HashSet(0);
	private Set downloadInfos = new HashSet(0);

	public PhotoInfo() {
	}

	public PhotoInfo(AlbumInfo albumInfo, UserInfo userInfo, TagInfo tagInfo,
			String PDes, Float PLoclat, Float PLoclng, Date PCreatetime,
			String PPath, Integer PDownnum, Integer PLikenum,
			Boolean PIfmodify, Integer PMainc1, Float PMainc1p,
			Integer PMainc2, Float PMainc2p, Set noticeInfos, Set commentInfos,
			Set downloadInfos) {
		this.albumInfo = albumInfo;
		this.userInfo = userInfo;
		this.tagInfo = tagInfo;
		this.PDes = PDes;
		this.PLoclat = PLoclat;
		this.PLoclng = PLoclng;
		this.PCreatetime = PCreatetime;
		this.PPath = PPath;
		this.PDownnum = PDownnum;
		this.PLikenum = PLikenum;
		this.PIfmodify = PIfmodify;
		this.PMainc1 = PMainc1;
		this.PMainc1p = PMainc1p;
		this.PMainc2 = PMainc2;
		this.PMainc2p = PMainc2p;
		this.noticeInfos = noticeInfos;
		this.commentInfos = commentInfos;
		this.downloadInfos = downloadInfos;
	}

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public AlbumInfo getAlbumInfo() {
		return this.albumInfo;
	}

	public void setAlbumInfo(AlbumInfo albumInfo) {
		this.albumInfo = albumInfo;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public TagInfo getTagInfo() {
		return this.tagInfo;
	}

	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}

	public String getPDes() {
		return this.PDes;
	}

	public void setPDes(String PDes) {
		this.PDes = PDes;
	}

	public Float getPLoclat() {
		return this.PLoclat;
	}

	public void setPLoclat(Float PLoclat) {
		this.PLoclat = PLoclat;
	}

	public Float getPLoclng() {
		return this.PLoclng;
	}

	public void setPLoclng(Float PLoclng) {
		this.PLoclng = PLoclng;
	}

	public Date getPCreatetime() {
		return this.PCreatetime;
	}

	public void setPCreatetime(Date PCreatetime) {
		this.PCreatetime = PCreatetime;
	}

	public String getPPath() {
		return this.PPath;
	}

	public void setPPath(String PPath) {
		this.PPath = PPath;
	}

	public Integer getPDownnum() {
		return this.PDownnum;
	}

	public void setPDownnum(Integer PDownnum) {
		this.PDownnum = PDownnum;
	}

	public Integer getPLikenum() {
		return this.PLikenum;
	}

	public void setPLikenum(Integer PLikenum) {
		this.PLikenum = PLikenum;
	}

	public Boolean getPIfmodify() {
		return this.PIfmodify;
	}

	public void setPIfmodify(Boolean PIfmodify) {
		this.PIfmodify = PIfmodify;
	}

	public Integer getPMainc1() {
		return this.PMainc1;
	}

	public void setPMainc1(Integer PMainc1) {
		this.PMainc1 = PMainc1;
	}

	public Float getPMainc1p() {
		return this.PMainc1p;
	}

	public void setPMainc1p(Float PMainc1p) {
		this.PMainc1p = PMainc1p;
	}

	public Integer getPMainc2() {
		return this.PMainc2;
	}

	public void setPMainc2(Integer PMainc2) {
		this.PMainc2 = PMainc2;
	}

	public Float getPMainc2p() {
		return this.PMainc2p;
	}

	public void setPMainc2p(Float PMainc2p) {
		this.PMainc2p = PMainc2p;
	}

	public Set getNoticeInfos() {
		return this.noticeInfos;
	}

	public void setNoticeInfos(Set noticeInfos) {
		this.noticeInfos = noticeInfos;
	}

	public Set getCommentInfos() {
		return this.commentInfos;
	}

	public void setCommentInfos(Set commentInfos) {
		this.commentInfos = commentInfos;
	}

	public Set getDownloadInfos() {
		return this.downloadInfos;
	}

	public void setDownloadInfos(Set downloadInfos) {
		this.downloadInfos = downloadInfos;
	}

}

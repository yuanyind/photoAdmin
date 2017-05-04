package bs.photoAdmin.friend.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import bs.photoAdmin.album.service.AlbumService;
import bs.photoAdmin.friend.service.FriendService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.photo.service.PhotoService;
import bs.photoAdmin.user.service.UserService;


public class FriendAction {
	private UserInfo userInfo;
	private FriendInfo friendInfo;
	private FgroupInfo fgInfo;
	private FriendService friendService;
	private AlbumService albumService;
	private PhotoService photoService;
	private UserService userService;
	private Integer otherFid;
	private Integer fgId;
	private int[] fgs;
	private String verifyMsg;
	private Integer fid;
	private Integer ad;
	private boolean ifModify;
	
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public FriendInfo getFriendInfo() {
		return friendInfo;
	}
	
	public void setFriendInfo(FriendInfo friendInfo) {
		this.friendInfo = friendInfo;
	}
	
	public FgroupInfo getFgInfo() {
		return fgInfo;
	}
	
	public void setFgInfo(FgroupInfo fgInfo) {
		this.fgInfo = fgInfo;
	}
	
	public FriendService getFriendService() {
		return friendService;
	}
	
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getOtherFid() {
		return otherFid;
	}

	public void setOtherFid(Integer otherFid) {
		this.otherFid = otherFid;
	}

	public Integer getFgId() {
		return fgId;
	}

	public void setFgId(Integer fgId) {
		this.fgId = fgId;
	}

	public int[] getFgs() {
		return fgs;
	}

	public void setFgs(int[] fgs) {
		this.fgs = fgs;
	}
	public String getVerifyMsg() {
		return verifyMsg;
	}

	public void setVerifyMsg(String verifyMsg) {
		this.verifyMsg = verifyMsg;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public Integer getAd() {
		return ad;
	}

	public void setAd(Integer ad) {
		this.ad = ad;
	}
	
	public AlbumService getAlbumService() {
		return albumService;
	}

	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	public boolean isIfModify() {
		return ifModify;
	}

	public void setIfModify(boolean ifModify) {
		this.ifModify = ifModify;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	//添加好友
	public String addFriend(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		
		List<FgroupInfo> list=friendService.listAllFgroup(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("fgroups",list);
		
		
		boolean flag= friendService.addFriend(u, otherFid);
		if(flag){
			return "verifyMsg";
		}
		else{
			return "default";
		}
	}
	//确认好友分组，验证信息
	public String verifyMsg(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		
		FgroupInfo fg = new FgroupInfo();
		fg=friendService.queryFgroupById(fgInfo.getFgId());
		System.out.print("\ninto Service");
		boolean flag=friendService.verifyMsg(u,otherFid, fg, verifyMsg);
		if(flag){
			return "success";
		}else{
			return "default";
		}
	}
	//通过添加，选择好友分组
	public String chooseFgroup(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<FgroupInfo> list=friendService.listAllFgroup(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("fgroups",list);
		
		FriendInfo f=friendService.queryByFid(fid);
		request=(Map)ActionContext.getContext().get("request");
		request.put("friend",f);
		
		return "chooseFgroup";
	}
	//确认分组
	public String chooseFgroupSet(){

		FgroupInfo fg = new FgroupInfo();
		fg=friendService.queryFgroupById(fgInfo.getFgId());
		
		FriendInfo f = friendService.queryByFid(fid);
		boolean flag=friendService.chooseFgroup(f,fg);
		if(flag){
			return listAll();
		}else{
			return "default";
		}	
	}
	//删除好友
	public String deleteFriend(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		UserInfo otherUser=userService.queryById(userInfo.getUserId());
		boolean flag=friendService.deleteFriend(u,otherUser);
		if(flag){
			return listAllGroup();
		}
		else{
			return "default";
		}
	}
	//显示所有好友
	public String listAll(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<FriendInfo> list=friendService.listAllFriend(u);
		
		request=(Map)ActionContext.getContext().get("request");
		request.put("friends",list);
		
		Set<UsericonInfo> iconset=new HashSet<UsericonInfo>();
		for(int i=0;i<list.size();i++){
			System.out.print("\n"+i+list.get(i).getUserInfoByOtheruserId().getUserName());
			iconset.add(userService.queryIconByUser(list.get(i).getUserInfoByOtheruserId()));
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons",iconset);
		return "showAllFriends";
	}
	//按分组显示好友
	public String listGroupFriend(){
		List<FriendInfo> list=friendService.queryByFgid(fgInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("friends",list);
		Set<UsericonInfo> iconset=new HashSet<UsericonInfo>();
		for(int i=0;i<list.size();i++){
			System.out.print("\n"+i+list.get(i).getUserInfoByOtheruserId().getUserName());
			iconset.add(userService.queryIconByUser(list.get(i).getUserInfoByOtheruserId()));
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons",iconset);
		return "showGroupFriends";
		
	}
	
	//显示好友分组
	public String listAllGroup(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<FgroupInfo> list=friendService.listAllFgroup(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("fgroups",list);
		return "showAllGroups";
	}
	//添加好友分组
	public String newGroup(){
		fgInfo.setFgNumber(0);
		boolean flag= friendService.addFgroup(fgInfo);
		if(flag){
			return listAllGroup();
		}
		else{
			return "default";
		}
	}
	//删除好友分组
	public String deleteGroup(){
		
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		System.out.print(u.getUserName());
		boolean flag=friendService.deleteFgroup(u, fgs);
		if(flag){
			return listAllGroup();
		}
		else{
			return "defalut";
		}
	}
	
	//按分组选择共享好友
	public String getShareFriends(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<FgroupInfo> fglists=friendService.listAllFgroup(u);
		List<FriendInfo> friendset = new ArrayList<FriendInfo>();
		for(int i=0;i<fglists.size();i++){
				friendset.addAll(fglists.get(i).getFriendInfos());
		}
		
		Set<UsericonInfo> iconset=new HashSet<UsericonInfo>();
		for(int i=0;i<friendset.size();i++){
			iconset.addAll(friendset.get(i).getUserInfoByOtheruserId().getUsericonInfos());
		}
		System.out.print("albumId:"+ad);
		AlbumInfo albumInfo=albumService.queryAlbumById(ad);
		System.out.print("/naname:");
		System.out.print(albumInfo.getAName());
		
		Set<PhotoInfo> photoset=new HashSet<PhotoInfo>();
			if(albumInfo.getPhotoInfos().size()!=0){
			PhotoInfo photo1=(PhotoInfo)albumInfo.getPhotoInfos().iterator().next();
			photoset.add(photo1);
		}
		
		request=(Map)ActionContext.getContext().get("request");
		request.put("fgroups", fglists);
		request.put("fs", friendset);
		request.put("icons", iconset);
		request.put("album", albumInfo);
		request.put("photos",photoset);
		return "showShareFriends";
	}
	
	//选择相册是否共同修改
	public String ifModifyAlbum(){
		AlbumInfo albumInfo=albumService.queryAlbumById(ad);
		List<PhotoInfo> ps=photoService.showPhotos(albumInfo);
		if(albumService.updateAlbum2(albumInfo,ifModify)){
			for(int i=0;i<ps.size();i++){
				ps.get(i).setPIfmodify(ifModify);
				photoService.updatePhoto(ps.get(i));
			}
			return "modifySuccess";
		}else{
			return "default";
		}
	}
	
	
}

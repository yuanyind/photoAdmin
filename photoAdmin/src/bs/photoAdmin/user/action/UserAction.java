package bs.photoAdmin.user.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import bs.photoAdmin.friend.service.FriendService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.msg.service.MsgService;
import bs.photoAdmin.photo.service.PhotoService;
import bs.photoAdmin.user.service.UserService;


public class UserAction {

	private UserInfo userInfo;
	private UserService userService;
	private String nickName;
	private UserInfo otherUserInfo;
	private UsericonInfo iconInfo;
	private PhotoService photoService;
	private FriendService friendService;
	private MsgService msgService;
	private Integer chooseSearch;
	private String searchCon;
	private Map<String,Object> session;
	private Map<String, Object> request;
	
	
	public UserInfo getUser() {
		return userInfo;
	}
	public void setUser(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserInfo getOtherUserInfo() {
		return otherUserInfo;
	}
	public void setOtherUserInfo(UserInfo otherUserInfo) {
		this.otherUserInfo = otherUserInfo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UsericonInfo getIconInfo() {
		return iconInfo;
	}
	public void setIconInfo(UsericonInfo iconInfo) {
		this.iconInfo = iconInfo;
	}
	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public MsgService getMsgService() {
		return msgService;
	}
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}
	public Integer getChooseSearch() {
		return chooseSearch;
	}
	public void setChooseSearch(Integer chooseSearch) {
		this.chooseSearch = chooseSearch;
	}
	public String getSearchCon() {
		return searchCon;
	}
	public void setSearchCon(String searchCon) {
		this.searchCon = searchCon;
	}
	
	
	//退出登录
	public String logoutUser(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	//用户验证
	public String checkUser(){
		UserInfo u=userService.checkUser(userInfo);
		if(u!=null){
			session = ActionContext.getContext().getSession();
			session.put("u",u);
			return "successCheck";
		}else{
			return "default";
			}
	}
	
	//显示主页数据（头像、未读消息、好友动态）
	public String myInfoShow(){
		iconInfo=userService.queryIconByUser(userInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons",iconInfo);
		
		
		Integer countMsg=msgService.listRecverMsg(userInfo, true).size()+msgService.listRecverMsg(userInfo, false).size()
						+msgService.listReceverNotice(userInfo, false).size();
		request=(Map)ActionContext.getContext().get("request");
		request.put("count",countMsg);
		return "success";
	}
	
	//显示最新好友动态
	public String newUpdate(){
		List<PhotoInfo> photos=photoService.listPhotoByTime(userInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",photos);
		
		Set<UsericonInfo> iconset=new HashSet<UsericonInfo>();
		for(int i=0;i<photos.size();i++){
			iconset.addAll(photos.get(i).getUserInfo().getUsericonInfos());
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons", iconset);

		return "newUpdate";
	}
	//显示用户个人信息
	public String listMyInfo(){
		
		userInfo=userService.queryById(userInfo.getUserId());
		System.out.print("\nid:"+userInfo.getUserId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("user",userInfo);
		
		iconInfo=userService.queryIconByUser(userInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("myicon",iconInfo);
		
		List<PhotoInfo> photos=photoService.listPhotoByUser(userInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",photos);
		
		return "userInfo";
	}
	//用户注销
	public String LogoffUser(){
		int userId=userInfo.getUserId();
		boolean flag=userService.LogoffUser(userId);
		System.out.print("\n2");
		if(flag){
			return "logoff";
		}
		else{
			return "default";
		}
		
	}
	//修改用户信息
	public String modifyUser(){
		UserInfo u=userService.updateUser(userInfo);
		session=ActionContext.getContext().getSession();
		session.put("u",u);
		return listMyInfo();
	}
	
	//显示搜索到用户信息
	public String listUserInfo(){
		System.out.print(otherUserInfo.getUserId());
		otherUserInfo=userService.queryById(otherUserInfo.getUserId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("user",otherUserInfo);
		
		iconInfo=userService.queryIconByUser(otherUserInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons",iconInfo);
		
		List<PhotoInfo> photos=photoService.listPhotoByUser(otherUserInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",photos);
		System.out.print("/b");
		userInfo=userService.queryById(userInfo.getUserId());
		Integer isFriend=friendService.verifyIfFriend(userInfo, otherUserInfo);
		System.out.print("isFriend:"+isFriend);
		request=(Map)ActionContext.getContext().get("request");
		request.put("isFriend",isFriend);
		System.out.print("/bb");
		return "userInfo";
	}
	//查找用户
	public String searchUserByTheNickname(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<UserInfo> list= userService.queryByNickname(searchCon);
		for(int i=0;i<list.size();i++){
			if((u.getUserId()).equals(list.get(i).getUserId())){
				list.remove(i);
			}
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("users",list);
		
		Set<UsericonInfo> iconset=new HashSet<UsericonInfo>();
		for(int i=0;i<list.size();i++){
			iconset.addAll(list.get(i).getUsericonInfos());
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("icons", iconset);
		
		List<UserInfo> fs=new ArrayList<UserInfo>();	//好友
		List<UserInfo> afs=new ArrayList<UserInfo>();	//等待验证
		List<UserInfo> ss=new ArrayList<UserInfo>();	//陌生人
		
		for(int i=0;i<list.size();i++){
			int flag=friendService.verifyIfFriend(u, list.get(i));
			if(flag==1){
				fs.add(list.get(i));
			}else if(flag==0){
				afs.add(list.get(i));
			}else{
				ss.add(list.get(i));
			}
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("fs", fs);
		request.put("afs", afs);
		request.put("ss", ss);
		return "userList";	
	}
	
	//综合搜索
	public String searchItems(){
		if(chooseSearch==1){
			return searchUserByTheNickname();
		}
		else if(chooseSearch==2){
			return searchPhoto();
		}else{
			return "false";
		}
	}
	
	public String searchPhoto(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<PhotoInfo> list=photoService.queryPhotoByD(u, searchCon);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",list);
		
		List<AlbumInfo> list2=photoService.queryAlbum(u, searchCon);
		request=(Map)ActionContext.getContext().get("request");
		request.put("albums",list2);
		Set<PhotoInfo> photoset=new HashSet<PhotoInfo>();
		for(int i=0;i<list2.size();i++){
			if(list2.get(i).getPhotoInfos().size()!=0){
			PhotoInfo photo1=(PhotoInfo)list2.get(i).getPhotoInfos().iterator().next();
			photoset.add(photo1);
			System.out.print("\n"+i);
			}
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("photo",photoset);
	
		return "photoList";
	}
	
	
}

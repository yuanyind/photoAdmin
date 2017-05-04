package bs.photoAdmin.photo.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import bs.photoAdmin.album.service.AlbumService;
import bs.photoAdmin.comment.service.CommentService;
import bs.photoAdmin.friend.service.FriendService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.msg.service.MsgService;
import bs.photoAdmin.photo.service.PhotoService;
import bs.photoAdmin.tag.service.TagService;
import bs.photoAdmin.user.service.UserService;

public class PhotoAction {
	private PhotoService photoService; 
	private PhotoInfo photoInfo;
	private AlbumService albumService;
	private Integer albumId;
	private Integer tagId;
	private TagService tagService;
	private UserService userService;
	private Integer PId;		//photoId
	private Integer noticeId;	//noticeId
	private String tagName;
	private CommentService commentService;
	private CommentInfo commentInfo;
	private FriendInfo friendInfo;
	private FriendService friendService;
	private Integer otherFid;
	private String searchCon;	//搜索图片关键字
	private MsgService msgService;
	private Integer colorNo;	//mainColor颜色号
	private boolean ifModify;	//是否可以共同修改
	
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public PhotoInfo getPhotoInfo() {
		return photoInfo;
	}
	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}
	public AlbumService getAlbumService() {
		return albumService;
	}
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public TagService getTagService() {
		return tagService;
	}
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public Integer getPId() {
		return PId;
	}
	public void setPId(Integer pId) {
		PId = pId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public CommentInfo getCommentInfo() {
		return commentInfo;
	}
	public void setCommentInfo(CommentInfo commentInfo) {
		this.commentInfo = commentInfo;
	}
	public FriendInfo getFriendInfo() {
		return friendInfo;
	}
	public void setFriendInfo(FriendInfo friendInfo) {
		this.friendInfo = friendInfo;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public Integer getOtherFid() {
		return otherFid;
	}
	public void setOtherFid(Integer otherFid) {
		this.otherFid = otherFid;
	}
	public String getSearchCon() {
		return searchCon;
	}
	public void setSearchCon(String searchCon) {
		this.searchCon = searchCon;
	}
	public MsgService getMsgService() {
		return msgService;
	}
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getColorNo() {
		return colorNo;
	}
	public void setColorNo(Integer colorNo) {
		this.colorNo = colorNo;
	}
	public boolean isIfModify() {
		return ifModify;
	}
	public void setIfModify(boolean ifModify) {
		this.ifModify = ifModify;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//上传照片页面显示相册选择
	public String chooseAlbum(){
		UserInfo u=(UserInfo)ActionContext.getContext().getSession().get("u");
		List<AlbumInfo> list=albumService.listAllAlbum(u);
		
		request=(Map)ActionContext.getContext().get("request");
		request.put("albums",list);
		return "uploadPhoto";
	}
	//按相册显示相片
	public String showPhotos(){
		AlbumInfo albumInfo=albumService.queryAlbumById(albumId);
		List<PhotoInfo> list=photoService.showPhotos(albumInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",list);
		return "showPhotosByAlbum";
	}
	//显示相片信息（包括tag，描述等）
	public String showPhotoInfo(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("photoInfo",photoInfo);
		
		List<CommentInfo> list=commentService.listComment(photoInfo);
		request.put("comments",list);
		
		List<FriendInfo> list2=friendService.listAllFriend(u);
		request.put("fs",list2);
		
		List<UsericonInfo> icons=new ArrayList<UsericonInfo>();
		icons.addAll(userService.queryIcons());
		request.put("icons", icons);
		
		List<AlbumInfo> alist=albumService.listAllAlbum(u);
		Integer ifOwner=0;
		for(int i=0;i<alist.size();i++){
			if((alist.get(i).getAId()).equals(photoInfo.getAlbumInfo().getAId())){
				ifOwner=1;
				break;
			}
		}
		request.put("ifOwner",ifOwner);
		return "showPhotoInfo";
	}
	//查看相片评论
	public String checkComment(){
		System.out.print("noticeId:");
		System.out.print(noticeId);
		NoticeInfo notice=msgService.queryNoticeById(noticeId);
		
		photoInfo=notice.getPhotoInfo();
		boolean flag=msgService.deleteNotice(noticeId);
		if(flag){
			UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
			
			request=(Map)ActionContext.getContext().get("request");
			request.put("photoInfo",photoInfo);
			
			List<CommentInfo> list=commentService.listComment(photoInfo);
			request=(Map)ActionContext.getContext().get("request");
			request.put("comments",list);
			
			List<FriendInfo> list2=friendService.listAllFriend(u);
			request=(Map)ActionContext.getContext().get("request");
			request.put("fs",list2);
			
			List<UsericonInfo> icons=new ArrayList<UsericonInfo>();
			icons.addAll(userService.queryIcons());
			request.put("icons", icons);
			return "showPhotoInfo";
		}else{
			return "default";
		}
		
	}
	//修改相片描述
	public String addPhotoDes(){
		
		String Pdes=photoInfo.getPDes();
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		photoInfo.setPDes(Pdes);
		boolean flag=photoService.updatePhoto(photoInfo);
		if(flag){
			return showPhotoInfo();
		}else{
			return "default";
		}
	}
	//修改所属相册
	public String changeAlbum(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<AlbumInfo> list=albumService.listAllAlbum(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("albums",list);
		
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("photoInfo",photoInfo);
		return "changeAlbum";
	}
	//确认修改相册
	public String makeChangeAlbum(){
		
		
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		
		//减少原先数量
		AlbumInfo beforeAlbum=photoInfo.getAlbumInfo();
		beforeAlbum.setANumber(beforeAlbum.getPhotoInfos().size()-1);
		albumService.updateAlbum(beforeAlbum);
		
		//更新所属相册
		AlbumInfo albumInfo=albumService.queryAlbumById(albumId);
		photoInfo.setAlbumInfo(albumInfo);
		
		boolean flag=photoService.updatePhoto(photoInfo);
		if(flag){
			//增加现在相册数量
			albumInfo.setANumber(albumInfo.getPhotoInfos().size()+1);
			albumService.updateAlbum(albumInfo);
			return showPhotoInfo();
		}else{
			return "default";
		}
	}
	//修改tag
	public String changeTag(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<TagInfo> list=tagService.queryTagByUser(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("tags",list);
		
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("photoInfo",photoInfo);
		return "changeTag";
	}
	//确认修改tag
	public String makeChangeTag(){
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		System.out.print("tId");
		System.out.print(tagId);
		TagInfo tagInfo=tagService.queryTagById(tagId);
		photoInfo.setTagInfo(tagInfo);
		
		boolean flag=photoService.updatePhoto(photoInfo);
		if(flag){
			return showPhotoInfo();
		}else{
			return "default";
		}
	}
	//前往新建标签
	public String toNewTag(){
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("photoInfo",photoInfo);
		return "addTag";
	}
	//创建标签forTag
	public String addTag2(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		boolean flag=tagService.addTag(tagName, u);
		List<TagInfo> tags=tagService.queryTagByUser(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("tags", tags);
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("photoInfo",photoInfo);
		if(flag){
			return "newTag2";
		}
		else{
			return "false";
		}
	}
	
	//添加评论
	public String addComment(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		photoInfo=photoService.queryPhotoById(photoInfo.getPId());
		System.out.print(otherFid);
		boolean flag=commentService.addComment(u, otherFid, commentInfo.getCommentContent(), photoInfo);
		if(flag){
			return showPhotoInfo();
		}else{
			return "default";
		}
	}
	//搜索相片
	public String searchPhoto(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<PhotoInfo> list=photoService.queryPhotoByD(u, searchCon);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",list);
		
		List<AlbumInfo> list2=photoService.queryAlbum(u, searchCon);
		request=(Map)ActionContext.getContext().get("request");
		request.put("albums",list2);
		
		return "photoList";
	}
	//列出所有所选颜色图片
	public String showColorPhoto(){
		List<PhotoInfo> cPhotos=photoService.queryPhotoByColor(colorNo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",cPhotos);
		return "photoByC";
	}
	//是否可以共同修改该相片
	public String ifModifyToge(){
		photoInfo=photoService.queryPhotoById(PId);
		photoInfo.setPIfmodify(ifModify);
		if(photoService.updatePhoto(photoInfo)){
			return showPhotoInfo();
		}else{
			return "default";
		}
		
	}
}

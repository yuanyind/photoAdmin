package bs.photoAdmin.album.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.album.service.AlbumService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.tag.service.TagService;

import com.opensymphony.xwork2.ActionContext;

public class AlbumAction {
	private AlbumInfo albumInfo;
	private UserInfo userInfo;
	private UserHasAlbumInfo uhaInfo;
	private TagInfo tagInfo;
	private AlbumService albumService;
	private TagService tagService;
	private int[] as;
	private int[] uds;  //共享相册的用户的Ids
	private int tagId;
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	public AlbumInfo getAlbumInfo() {
		return albumInfo;
	}
	public void setAlbumInfo(AlbumInfo albumInfo) {
		this.albumInfo = albumInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserHasAlbumInfo getUhaInfo() {
		return uhaInfo;
	}
	public void setUhaInfo(UserHasAlbumInfo uhaInfo) {
		this.uhaInfo = uhaInfo;
	}
	public AlbumService getAlbumService() {
		return albumService;
	}
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}
	public int[] getAs() {
		return as;
	}
	public void setAs(int[] as) {
		this.as = as;
	}	
	public int[] getUds() {
		return uds;
	}
	public void setUds(int[] uds) {
		this.uds = uds;
	}
	public TagInfo getTagInfo() {
		return tagInfo;
	}
	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}
	public TagService getTagService() {
		return tagService;
	}
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	//创建相册
	public String addAlbum(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		TagInfo tagInfo=tagService.queryTagById(tagId);
		boolean flag=albumService.addAlbum(u,albumInfo,tagInfo);
		if(flag){
			return listAllAlbum();
		}
		else{
			return "default";
		}
	}
	//显示所有相册
	public String listAllAlbum(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		List<AlbumInfo> list=albumService.listAllAlbum(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("albums",list);
		
		Set<PhotoInfo> photoset=new HashSet<PhotoInfo>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPhotoInfos().size()!=0){
			PhotoInfo photo1=(PhotoInfo)list.get(i).getPhotoInfos().iterator().next();
			photoset.add(photo1);
			System.out.print("\n"+i);
			}
		}
		request=(Map)ActionContext.getContext().get("request");
		request.put("photos",photoset);
		
		return "showAllAlbums";
	}
	//删除相册
	public String deleteAlbum(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		
		boolean flag=albumService.deleteAlbum(u, as);
		if(flag){
			return listAllAlbum();
		}else{
			return "defalut";
		}
	}
	//分享相册
	public String shareAlbum(){
		AlbumInfo aInfo=new AlbumInfo();
		
		aInfo=albumService.queryAlbumById(albumInfo.getAId());
		
		boolean flag=albumService.addUserHasAlbum(aInfo, uds);
		if(flag){
			return listAllAlbum();
		}else{
			return "defalut";
		}
	}
	//列出相册可选标签
	public String chooseTag(){
		
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		
		
		List<TagInfo> tags=tagService.queryTagByUser(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("tags", tags);
		return "newAlbum";
	}
	
}

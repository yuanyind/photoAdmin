package bs.photoAdmin.tag.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.tag.service.TagService;

public class TagAction {
	private TagInfo tagInfo;
	private UserInfo userInfo;
	private TagService tagService;
	private String tagName;
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	public TagInfo getTagInfo() {
		return tagInfo;
	}
	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public TagService getTagService() {
		return tagService;
	}
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	//创建标签forAlbum
	public String addTag(){
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
		boolean flag=tagService.addTag(tagName, u);
		List<TagInfo> tags=tagService.queryTagByUser(u);
		request=(Map)ActionContext.getContext().get("request");
		request.put("tags", tags);
		if(flag){
			return "newTag";
		}
		else{
			return "false";
		}
	}
	
	
	
}

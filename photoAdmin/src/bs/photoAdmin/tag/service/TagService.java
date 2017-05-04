package bs.photoAdmin.tag.service;

import java.util.List;

import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;

public interface TagService {
	//创建标签
	public boolean addTag(String tagName, UserInfo u);
	//获得标签byId
	public TagInfo queryTagById(Integer tId);
	//获得用户所有标签
	public List<TagInfo> queryTagByUser(UserInfo u);
}

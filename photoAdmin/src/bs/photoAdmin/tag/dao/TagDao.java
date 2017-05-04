package bs.photoAdmin.tag.dao;

import java.util.List;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;

public interface TagDao {
	//创建标签
	public void addTag(TagInfo tagInfo);
	//更新标签
	public void updateTag(TagInfo tagInfo);
	//获得标签byId
	public TagInfo getTagById(int tId);
	//获得用户所有标签
	public List<TagInfo> getTagByUser(UserInfo u);
	//获得标签byTagName
	public List<TagInfo> getTagByName(String tName);
}

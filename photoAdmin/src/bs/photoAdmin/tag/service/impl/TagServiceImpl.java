package bs.photoAdmin.tag.service.impl;

import java.util.List;

import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.tag.dao.TagDao;
import bs.photoAdmin.tag.service.TagService;

public class TagServiceImpl implements TagService {
	
	private TagDao tagDao;
	
	public TagDao getTagDao() {
		return tagDao;
	}
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	
	
	//创建标签
	public boolean addTag(String tagName, UserInfo u){
		try{
			TagInfo tagInfo=new TagInfo();
			tagDao.addTag(tagInfo);
			tagInfo.setTagName(tagName);
			tagInfo.setUserInfo(u);
			tagDao.updateTag(tagInfo);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//获得标签byId
	public TagInfo queryTagById(Integer tId){
		return tagDao.getTagById(tId);
	}
	//获得用户所有标签
	public List<TagInfo> queryTagByUser(UserInfo u){
		System.out.print("\nthis is service");
		return tagDao.getTagByUser(u);
	}
	
}

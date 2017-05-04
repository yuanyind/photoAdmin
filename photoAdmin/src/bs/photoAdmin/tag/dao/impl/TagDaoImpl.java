package bs.photoAdmin.tag.dao.impl;

import java.util.List;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.tag.dao.TagDao;

public class TagDaoImpl extends HibernateDaoSupport implements TagDao{
	//创建标签
	public void addTag(TagInfo tagInfo){
		this.getHibernateTemplate().save(tagInfo);
	}
	//更新标签
	public void updateTag(TagInfo tagInfo){
		this.getHibernateTemplate().update(tagInfo);
	}
	//获得标签byId
	public TagInfo getTagById(int tId){
		Query q=this.getSession().createQuery("from TagInfo t where t.tagId=:tagId");
		q.setParameter("tagId", tId);
		TagInfo tagInfo=(TagInfo)q.uniqueResult();
		return tagInfo;
	}
	//获得用户所有标签
	public List<TagInfo> getTagByUser(UserInfo u){
		System.out.print("\nthis is dao");
		Query q=this.getSession().createQuery("from TagInfo t where t.userInfo is null or t.userInfo=:userInfo");
		System.out.print("\ndao2");
		System.out.print(q);
		q.setParameter("userInfo", u);
		List<TagInfo> tagInfos=q.list();
		return tagInfos;
	}
	//获得标签byTagName
	public List<TagInfo> getTagByName(String tName){
		Query q=this.getSession().createQuery("from TagInfo t where t.tagName like :tagName");
		q.setParameter("tagName","%"+ tName+"%");
		List<TagInfo> tagInfos=q.list();
		return tagInfos;
	}
	
}

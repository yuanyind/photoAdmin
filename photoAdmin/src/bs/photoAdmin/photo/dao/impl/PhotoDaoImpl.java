package bs.photoAdmin.photo.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.photo.dao.PhotoDao;

public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao{
	//保存图片
	public void addPhoto(PhotoInfo photoInfo){
		Configuration cfg=new Configuration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		session.beginTransaction();
		
		session.save(photoInfo);
		
		session.getTransaction().commit();
		session.close();
	}
	//更新图片
	public void updatePhoto(PhotoInfo photoInfo){
		this.getHibernateTemplate().update(photoInfo);
	}
	//显示照片
	public List<PhotoInfo> showPhoto(AlbumInfo albumInfo){
		Query q=this.getSession().createQuery("from PhotoInfo p where p.albumInfo =:albumInfo");
		q.setParameter("albumInfo",albumInfo);
		List<PhotoInfo> photos=q.list();
		return photos;
	}
	//查找照片byId
	public PhotoInfo queryById(Integer PId){
		Query q=this.getSession().createQuery("from PhotoInfo p where p.PId=:PId");
		q.setParameter("PId", PId);
		PhotoInfo p=(PhotoInfo)q.uniqueResult();
		return p;
	}
	//查找照片byDes
	public List<PhotoInfo> queryByD(AlbumInfo albumInfo, String searchCon){
		
		Query q=this.getSession().createQuery("from PhotoInfo p where p.PDes like :PDes and p.albumInfo=:albumInfo");
		q.setParameter("PDes", "%"+searchCon+"%");
		q.setParameter("albumInfo", albumInfo);
		List<PhotoInfo> photos=q.list();
		
		return photos;
	}

	//查找照片byTag
	public List<PhotoInfo> queryByTag(TagInfo tagInfo){
		Query q=this.getSession().createQuery("from PhotoInfo p where p.tagInfo=:tagInfo");
		q.setParameter("tagInfo", tagInfo);
		List<PhotoInfo> photos=q.list();
		return photos;
	}
	//显示图片byTime
	public List<PhotoInfo> listPhotoByTime(){
		Query q=this.getSession().createQuery("from PhotoInfo p order by PCreatetime desc");
		List<PhotoInfo> photos=q.list();
		return photos;
	}
	//查找照片bypPath
	public PhotoInfo queryByPath(String pPath){
		Query q=this.getSession().createQuery("from PhotoInfo p where p.PPath=:PPath");
		q.setParameter("PPath", pPath);
		PhotoInfo p=(PhotoInfo)q.uniqueResult();
		return p;
	}
	//查找照片by主色
	public List<PhotoInfo> queryByMainColor(Integer colorNo){
		Query q=this.getSession().createQuery("from PhotoInfo p where p.PMainc1=:colorNo and p.PMainc1p>=40 order by p.PMainc1p desc");
		q.setParameter("colorNo", colorNo);
		List<PhotoInfo> p=q.list();
		return p;
	}
	
}

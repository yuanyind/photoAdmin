package bs.photoAdmin.album.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.album.dao.AlbumDao;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;


public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao {
	//创建相册
	public void addAlbum(AlbumInfo album){
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(album);
		session.getTransaction().commit();
		session.close();
	}
	//删除相册
	public void deleteAlbum(AlbumInfo album){
		this.getHibernateTemplate().delete(album);
	}
	//更新相册
	public void updateAlbum(AlbumInfo album){
		this.getHibernateTemplate().update(album);
	}
	//更新相册2
	public void updateAlbum2(AlbumInfo album,boolean ifModify){
		System.out.print(album.getAId());
		System.out.print(album.getAlbumIfsee());
		Query q=this.getSession().createQuery("Update AlbumInfo a set a.albumIfsee=:albumIfsee where a.AId=:AId");
		q.setParameter("albumIfsee",  ifModify);
		q.setParameter("AId", album.getAId());
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		System.out.print("\ndao1");   
		session.beginTransaction();
		System.out.print("\ndao2");
		   q.executeUpdate();
		   System.out.print("\ndao3");
		   session.getTransaction().commit();
		   System.out.print("\ndao4");
		   session.flush();
		   System.out.print("\ndao5");
		   session.close();
		   System.out.print("\ndao6");
	}
	//查找相册byName
	public List<AlbumInfo> queryAlbumInfoByName(Integer aId, String albumName){
		Query q=this.getSession().createQuery("from AlbumInfo a where (a.AName=:albumName or a.ADes=:albumName) and a.AId=:aId");
		q.setParameter("aId", aId);
		q.setParameter("albumName", albumName);
		List<AlbumInfo> albums=q.list();
		return albums;
	}
	//查找相册byTag
	public List<AlbumInfo> queryAlbumByTag(TagInfo tagInfo){
		Query q=this.getSession().createQuery("from AlbumInfo a where a.tagInfo=:tagInfo");
		q.setParameter("tagInfo", tagInfo);
		List<AlbumInfo> albums=q.list();
		return albums;
	}
		
	//查找相册byId
	public AlbumInfo queryAlbumById(int aId){
		Query q=this.getSession().createQuery("from AlbumInfo a where a.AId=:aId");
		q.setParameter("aId",aId);
		AlbumInfo albums=(AlbumInfo)q.uniqueResult();
		return albums;

	}
	//显示所有相册
	public List<AlbumInfo> listAllAlbum(UserInfo userInfo){
		Query q=this.getSession().createQuery("select albumInfo from UserHasAlbumInfo uha where uha.userInfo=:userInfo");
		q.setParameter("userInfo", userInfo);
		List<AlbumInfo> albums=q.list();
		return albums;
	}
	//获得用户初始化相册的id
	public AlbumInfo getIniAlbumId(UserInfo userInfo){
		Query q=this.getSession().createQuery("select UserHasAlbumInfo.albumInfo from UserHasAlbumInfo uha, AlbumInfo a where uha.userInfo=:userInfo and a.AName=:albumName");
		q.setParameter("userInfo", userInfo);
		q.setParameter("albumName", "moren");
		AlbumInfo albums=(AlbumInfo)q.uniqueResult();
		return albums;
	}
	//通过user和album查找userHasAlbum表
	public UserHasAlbumInfo getUserHasAlbumInfo(UserInfo u, AlbumInfo albumInfo){
		Query q=this.getSession().createQuery("from UserHasAlbumInfo uha where uha.userInfo=:userInfo and uha.albumInfo=:albumInfo");
		q.setParameter("userInfo", u);
		q.setParameter("albumInfo", albumInfo);
		UserHasAlbumInfo uha=(UserHasAlbumInfo)q.uniqueResult();
		return uha;
	}
	//通过user查uha表
	public List<UserHasAlbumInfo> queryUhaByUser(UserInfo u){
		Query q=this.getSession().createQuery("from UserHasAlbumInfo uha where uha.userInfo=:userInfo");
		q.setParameter("userInfo", u);
		List<UserHasAlbumInfo> uhas=q.list();
		return uhas;
	}
	//创建相册用户关系表
	public void addUserHasAlbum(UserHasAlbumInfo uhaInfo){
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(uhaInfo);
		session.getTransaction().commit();
		session.close();
	}
	//删除相册用户关系表
	public void deleteUserHasAlbum(UserHasAlbumInfo uhaInfo){
		this.getHibernateTemplate().delete(uhaInfo);
	}
	//更新相册用户关系表
	public void updateUserHasAlbum(UserHasAlbumInfo uhaInfo){
		this.getHibernateTemplate().update(uhaInfo);
	}
}

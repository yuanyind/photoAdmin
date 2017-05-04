package bs.photoAdmin.friend.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bs.photoAdmin.friend.dao.FriendDao;
import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.UserInfo;


public class FriendDaoImpl extends HibernateDaoSupport implements FriendDao{
	//添加好友
		public void addFriend(FriendInfo friendInfo){
			
			this.getHibernateTemplate().save(friendInfo);
			
		}
		//删除好友
		public void deleteFriend(FriendInfo friendInfo){
			this.getHibernateTemplate().delete(friendInfo);
			
		}
		//更新好友
		public void updateFriend(FriendInfo friendInfo){
			
			Configuration cfg=new Configuration().configure();
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			session.beginTransaction();
			
			session.update(friendInfo);
			
			session.getTransaction().commit();
			 session.flush();
			session.close();
		}
		//更新好友
		public void updateFriend2(FriendInfo friendInfo){
			this.getHibernateTemplate().update(friendInfo);
		}
		//显示所有好友
		public List<FriendInfo> listAllFriend(UserInfo u){
			Query q=this.getSession().createQuery("from FriendInfo f where f.userInfoBySelfuserId=:u and f.fgIsPass=:true");
			q.setParameter("u", u);
			q.setParameter("true", true);
			List<FriendInfo> friends=q.list();
			return friends;
			
		}
		//查找好友ByFid
		public FriendInfo queryFriendById(int fId){
			
			String sql = "from FriendInfo f where f.FId=:id";
			Query q=this.getSession().createQuery(sql);
			
			q.setParameter("id",fId);
			
			FriendInfo f =(FriendInfo)q.uniqueResult();
			
			return f;
		}
		
		//查找好友byUser
		public FriendInfo queryFriendByUser(UserInfo selfUser, UserInfo otherUser){
			String sql="from FriendInfo f where f.userInfoBySelfuserId=:selfId and f.userInfoByOtheruserId=:otherId";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("selfId", selfUser);
			q.setParameter("otherId", otherUser);
			
			FriendInfo friendInfo=(FriendInfo)q.uniqueResult();
			return friendInfo;
			
		}
		
		//显示好友by分组
		public List<FriendInfo> queryByFgid(FgroupInfo fgInfo){
			Query q=this.getSession().createQuery("from FriendInfo f where f.fgroupInfo=:fgId and f.fgIsPass=:true");
			q.setParameter("fgId", fgInfo);
			q.setParameter("true", true);
			List<FriendInfo> friends=q.list();
			return friends;
		}
		//添加好友分组
		public void addFgroup(FgroupInfo fgInfo){
			
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			session.beginTransaction();
			session.save(fgInfo);
			session.getTransaction().commit();
			session.close();
			
		}
		//删除好友分组
		public void deleteFgroup(FgroupInfo fgInfo){
			
			getHibernateTemplate().delete(fgInfo);
			
		}
		//更新好友分组
		public void updateFgroup(FgroupInfo fgroupInfo,Integer fgNumber){
				Query q=this.getSession().createQuery("Update FgroupInfo fg set fgNumber=:fgNumber where fg.fgId=:fgId");
				q.setParameter("fgNumber", fgNumber);
				q.setParameter("fgId", fgroupInfo.getFgId());
				Session session=this.getHibernateTemplate().getSessionFactory().openSession();
				   session.beginTransaction();
				   q.executeUpdate();
				   session.getTransaction().commit();
				   session.flush();
				   session.close();
		}
		
		//显示好友分组
		public List<FgroupInfo> listAllFgroup(UserInfo u){
			Query q=this.getSession().createQuery("from FgroupInfo fg where fg.userInfo=:u");
			q.setParameter("u", u);
			List<FgroupInfo> fgs=q.list();
			return fgs;
		}
		//查找好友分组
		public FgroupInfo queryFgroupById(int fgId){
			
			String sql = "from FgroupInfo fg where fg.fgId=:id";
			Query q=this.getSession().createQuery(sql);
			
			q.setParameter("id",fgId);
			
			FgroupInfo fg =(FgroupInfo)q.uniqueResult();
			
			return fg;
		}
		//获得用户初始化分组的id
		public FgroupInfo getIniFgId(UserInfo userInfo){
			String sql = "from FgroupInfo fg where fg.userInfo=:userInfo and fg.fgName=:fgName";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("userInfo", userInfo);
			q.setParameter("fgName", "moren");
			FgroupInfo fg = (FgroupInfo)q.uniqueResult();
			return fg;
		}
}

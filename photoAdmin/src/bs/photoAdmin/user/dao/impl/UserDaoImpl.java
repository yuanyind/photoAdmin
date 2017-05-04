package bs.photoAdmin.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.user.dao.UserDao;



public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	
		//用户注册	
		public void registerUser(UserInfo userInfo){
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			session.beginTransaction();
			session.save(userInfo);
			session.getTransaction().commit();
			session.close();
		}
		//用户注销
		public void logoffUser(UserInfo userInfo){
			
			
			this.getHibernateTemplate().delete(userInfo);
		}
		//更新用户
		public UserInfo updateUser(UserInfo user){
			
			this.getHibernateTemplate().update(user);
			
			return user;
		}
		//登陆验证
		public UserInfo checkUser(UserInfo user){
			String sql = "from UserInfo u where u.userName=:name and u.userPassword=:password";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("name",user.getUserName());
			q.setParameter("password",user.getUserPassword());
			
			UserInfo u = (UserInfo)q.uniqueResult();
				
			return u;
		}
		
		
		//查询用户byID
		public UserInfo queryById(int userId){
			
			String sql = "from UserInfo u where u.userId=:id";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("id",userId);
			
			UserInfo u =(UserInfo)q.uniqueResult();
			
			return u;
			
		}
		//查询用户byNickame
		public List<UserInfo> queryByNickname(String userNickname){
			
			String sql = "from UserInfo u where u.userNickname like :nickname";

			Query q=this.getSession().createQuery(sql);

			System.out.print(userNickname);
			q.setParameter("nickname","%"+userNickname+"%");
			System.out.print("\n"+sql);
			
			List<UserInfo> us =q.list();
			
			System.out.print("\n"+sql);
			return us;
		}
		//查询用户byName
		public UserInfo queryByName(String userName){
			String sql = "from UserInfo u where u.userName=:name";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("name",userName);
			
			UserInfo u =(UserInfo)q.uniqueResult();
			
			return u;
		}
		
		//查询用户byEmail
		public UserInfo queryByEmail(String userEmail){
			String sql = "from UserInfo u where u.userEmail=:email";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("email",userEmail);
			
			UserInfo u =(UserInfo)q.uniqueResult();
			
			return u;
		}
		
		//新建头像
		public void addIcon(UsericonInfo iconInfo){
			Configuration cfg=new Configuration().configure();
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			session.beginTransaction();
			
			session.save(iconInfo);
			
			session.getTransaction().commit();
			session.close();
		}
		//修改头像
		public void updateIcon(UsericonInfo iconInfo){
			this.getHibernateTemplate().update(iconInfo);
		}
		//查找头像byId
		public UsericonInfo queryIconById(Integer iconId){
			Query q=this.getSession().createQuery("from UsericonInfo i where i.iconId=:iconId");
			q.setParameter("iconId", iconId);
			UsericonInfo i=(UsericonInfo)q.uniqueResult();
			return i;
		}
		
		//查找头像byUser
		public UsericonInfo queryIconByUser(UserInfo userInfo){
			Query q=this.getSession().createQuery("from UsericonInfo i where i.userInfo=:userInfo");
			q.setParameter("userInfo", userInfo);
			UsericonInfo i=(UsericonInfo)q.uniqueResult();
			return i;
		}
		
		//获得所有头像
		public List<UsericonInfo> queryIcons(){
			Query q= this.getSession().createQuery("from UsericonInfo");
			List<UsericonInfo> icons=q.list();
			return icons;
		}
}

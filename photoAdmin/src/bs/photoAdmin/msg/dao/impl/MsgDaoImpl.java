package bs.photoAdmin.msg.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bs.photoAdmin.model.MsgInfo;
import bs.photoAdmin.model.NoticeInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.msg.dao.MsgDao;

public class MsgDaoImpl extends HibernateDaoSupport implements MsgDao{
	    //添加好友消息
		public void addMsg(MsgInfo msgInfo){
			
			Configuration cfg=new Configuration().configure();
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			session.beginTransaction();
			
			session.save(msgInfo);
			
			session.getTransaction().commit();
			session.close();
		}
		//消息列表byRecver
		public List<MsgInfo> listMsgByRecver(UserInfo u,boolean flag){
			String sql="from MsgInfo m where m.userInfoByMsgToUserId=:id and m.msgFlag=:flag";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("id",u);
			q.setParameter("flag",flag);
			List<MsgInfo> msgs=q.list();
			return msgs;

		}
		//消息列表bySender
		public List<MsgInfo> listMsgBySender(UserInfo u){
			String sql="from MsgInfo m where m.userInfoByMsgFromUserId=:id";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("id",u);
			List<MsgInfo> msgs=q.list();
			return msgs;
		}
		//查找消息byId
		public MsgInfo queryMsgById(Integer id){
			MsgInfo msgInfo = (MsgInfo)this.getHibernateTemplate().get(MsgInfo.class, id);
			return msgInfo;
		}
		//删除消息
		public void deleteMsg(MsgInfo msgInfo){
			
			Configuration cfg=new Configuration().configure();
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			session.beginTransaction();
			
			session.delete(msgInfo);
			
			session.getTransaction().commit();
			
			session.flush();
			
			session.close();
		}
		//更新消息
		public void updateMsg(MsgInfo msgInfo){
			this.getHibernateTemplate().update(msgInfo);
		}
		//更新消息
		public void updateMsg2(MsgInfo msgInfo){
			Configuration cfg=new Configuration().configure();
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			session.beginTransaction();
			
			session.update(msgInfo);
			
			session.getTransaction().commit();
			session.close();
		}
		//查找消息byUser
		public MsgInfo queryMsgByUser(UserInfo fromUser, UserInfo toUser){
			String sql="from MsgInfo m where m.userInfoByMsgFromUserId=:fromId and m.userInfoByMsgToUserId=:toId";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("fromId", fromUser);
			q.setParameter("toId", toUser);
			MsgInfo msg=(MsgInfo)q.uniqueResult();
			return msg;
		}
		
		
		//添加通知
		public void addNotice(NoticeInfo noticeInfo){
			this.getHibernateTemplate().save(noticeInfo);
		}
		//通知列表byRecever
		public List<NoticeInfo> listNoticByRecver(UserInfo u,boolean flag){
			String sql="from NoticeInfo n where userInfoByUserToUserId=:id and n.flag=:flag";
			Query q=this.getSession().createQuery(sql);
			q.setParameter("id",u);
			q.setParameter("flag",flag);
			List<NoticeInfo> notices=q.list();
			return notices;
		}
		//删除通知
		public void deleteNotice(NoticeInfo notice){
			this.getHibernateTemplate().delete(notice);
		}
		
		//查找通知byId
		public NoticeInfo queryNoticeById(Integer id){
			NoticeInfo noticeInfo = (NoticeInfo)this.getHibernateTemplate().get(NoticeInfo.class, id);
			return noticeInfo;
		}
}

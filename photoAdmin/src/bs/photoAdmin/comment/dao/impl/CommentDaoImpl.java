package bs.photoAdmin.comment.dao.impl;

import bs.photoAdmin.comment.dao.CommentDao;
import bs.photoAdmin.model.CommentInfo;
import bs.photoAdmin.model.PhotoInfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
	//添加评论
	public void addComment(CommentInfo commentInfo){
		this.getHibernateTemplate().save(commentInfo);
	}
	//删除评论
	public void deleteComment(CommentInfo commentInfo){
		this.getHibernateTemplate().delete(commentInfo);
	}
	//显示图片相关评论
	public List<CommentInfo> listCommentOfPhoto(PhotoInfo photoInfo){
		Query q=this.getSession().createQuery("from CommentInfo c where c.photoInfo=:photoInfo");
		q.setParameter("photoInfo", photoInfo);
		List<CommentInfo> comments=q.list();
		return comments;
	}
	
}

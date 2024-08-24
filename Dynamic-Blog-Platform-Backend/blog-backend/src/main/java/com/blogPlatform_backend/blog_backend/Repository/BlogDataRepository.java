package com.blogPlatform_backend.blog_backend.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogPlatform_backend.blog_backend.Entity.BlogData;

@Repository
public class BlogDataRepository {
	@Autowired
	SessionFactory factory;
	public String SaveData(BlogData bd) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(bd);
			tx.commit();
			msg = "Data saved successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
	public String UpdateData(BlogData bd, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			BlogData record = session.get(BlogData.class, id);
			record.setTitle(bd.getTitle());
			record.setContent(bd.getContent());
			session.merge(record);
			tx.commit();
			msg = "Data updated successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String DeleteData(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			BlogData record = session.get(BlogData.class, id);
			record.getId();
			session.remove(record);
			tx.commit();
			msg = "Data deleted successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public BlogData FetchSingleBlog(int id) {
		Session session = null;
		Transaction tx = null;
		BlogData record = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from BlogData where id=:id";
			Query<BlogData> query = session.createQuery(hqlQuery, BlogData.class);
			query.setParameter("id", id);
			record = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return record;
	}
	public List<BlogData> FetchAllBlogs() {
		Session session = null;
		Transaction tx = null;
		List<BlogData> list  = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from BlogData";
			Query<BlogData> query = session.createQuery(hqlQuery, BlogData.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
}

/**
 * 
 */
package com.hibernate.hibernatepractice;



import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Shweta kumari
 *
 */

/*
 * Generic class for hibernate persistence this should be extended by all DAO
 * class to reuse methods declared in this class
 */

public class HibernateDAO<T> {
	
	protected Class<T> elemClass;
	protected String name;
	Session session = HibernateUtil.getSession();
	public HibernateDAO(String className) {
		this.name = className;
	}

	
	protected HibernateDAO(Class<T> elemClass) {
		this.elemClass = elemClass;
	}

	public static <T> HibernateDAO<T> getDAO(Class<T> elemClass) {
		return new HibernateDAO<T>(elemClass);
	}
	
	
	public T save(T entity) {
		Transaction tx = null;
		tx = (Transaction) session.getTransaction();

		if (tx.isActive()) {
			session.joinTransaction();
		} else {
			session.beginTransaction();
		}
		try {
			session.save(entity);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				
				tx.rollback();
			}
		ex.printStackTrace();
		}
		
		return entity;
	}

	public T update(T entity) {
		Transaction tx = session.getTransaction();

		if (tx.isActive()) {
			session.joinTransaction();
		} else {
			session.beginTransaction();
		}

		try {
			session.update(entity);
			tx.commit();
		} catch (Exception ex) {
			
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}

	
		return entity;
	}
	
    public T merge(T entity) {
    	Transaction tx = session.getTransaction();

		if (tx.isActive()) {
			session.joinTransaction();
		} else {
			session.beginTransaction();
		}

		try {
			session.merge(entity);
			tx.commit();
		} catch (Exception ex) {
		
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(ex);
		}

		
		return entity;
    }
    
	public void delete(T entity) {

		Transaction tx = session.getTransaction();

		if (session.getTransaction().isActive()) {
			session.joinTransaction();
		} else {
			session.beginTransaction();
		}

		try {
			session.clear();
			session.delete(entity);
			tx.commit();
		} catch (Exception ex) {
		
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	public T find(Integer id) {
		return session.get(elemClass, id);
	}

	public Session getSession() {
		return session;
	}

	public void saveOrUpdate(T entity) {
		Transaction tx = null;
		tx = session.getTransaction();

		if (tx.isActive()) {
			session.joinTransaction();
		} else {
			session.beginTransaction();
		}
		try {
			session.saveOrUpdate(entity);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				
				tx.rollback();
			}
		ex.printStackTrace();
		}
		
	}
	
}

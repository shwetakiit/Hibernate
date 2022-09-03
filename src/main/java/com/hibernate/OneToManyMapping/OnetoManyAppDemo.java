package com.hibernate.OneToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernatepractice.HibernateUtil;

public class OnetoManyAppDemo {
	public static void main(String[] args) {
		/*Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory cfgFactory=cfg.buildSessionFactory();
	    Session session = cfgFactory.openSession();
	    session.beginTransaction();  */
	    
	    Session sessions= HibernateUtil.getSession();
	    sessions.beginTransaction();
	    UserDTO userDTO = new UserDTO(101,"Shweta");
	    
	    
	}

}

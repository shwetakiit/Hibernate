package com.hibernate.hibernatepractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author Shweta Kumari
 *
 */
public class HibernateUtil {
	private static StandardServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	
	//Create thread local variable of Session for each thread so here no need to use immutable class for thread safety
	
	 private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private  static volatile HibernateUtil hibernateUtil = null;
	
	private HibernateUtil() {
		
	}

/*	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	} */
	
	//Sttaic block is executed only once: the first time the class is loaded into memory
    static {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
             serviceRegistry = new StandardServiceRegistryBuilder()//
                    .configure("hibernate.cfg.xml").build();
 
            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
 
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {	         
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	 public synchronized static HibernateUtil getInstance(){
			if (hibernateUtil == null){
				hibernateUtil = new HibernateUtil();
			}
			return hibernateUtil;
		} 

	   
	  public static Session getSession() {
		  Session session = null;
		  if(threadLocal.get()==null) {
			  session= sessionFactory.openSession();
			  threadLocal.set(session);
			  
		  } else {
			   session = threadLocal.get();
			  
		  }
		  return session;
		  
	  }
	  
	  public static void closeSession() {
		  
		  Session session  = null;
		  if(threadLocal.get() != null ) {
			  session = threadLocal.get() ;
			  session.close();
			  threadLocal.remove();
			  
			  
		  }
		  
	  }
	  
	public static void shutdown() {
		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
	
}

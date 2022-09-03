package kumari.shweta.test;

import org.hibernate.Session;
import org.hibernate.annotations.Immutable;
import org.hibernate.sql.Delete;

import com.hibernate.hibernatepractice.HibernateDAO;
import com.hibernate.hibernatepractice.HibernateUtil;

import kumari.shweta.dto.ImmutableEntity;
import kumari.shweta.dto.UserDTO;

public class AppTest {
	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		HibernateDAO<UserDTO> dao=HibernateDAO.getDAO(UserDTO.class);
        session.beginTransaction();
        UserDTO userDTO= new UserDTO();
        userDTO.setUserName("shweta");
        dao.save(userDTO);
        
		/*
		 * Immutable Entity insert,update ,delete operation
		 *  No update operation on Immutable entity
		 */
        
       HibernateDAO<ImmutableEntity> immuDao = HibernateDAO.getDAO(ImmutableEntity.class);
       ImmutableEntity immutableEntity = new ImmutableEntity();
       immutableEntity.setAddress("BTM BLR");
       immutableEntity.setName("Alica");
       immuDao.save(immutableEntity);
       
       //Try update on immutable entity -->It doesn't throw any exception but it doesn't update entity
       immutableEntity.setName("Cary");
       immuDao.update(immutableEntity);
       }

}

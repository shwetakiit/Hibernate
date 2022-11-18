package kumari.shweta.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Immutable;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Delete;

import com.hibernate.hibernatepractice.HibernateDAO;
import com.hibernate.hibernatepractice.HibernateUtil;

import kumari.shweta.dto.HouseDTO;
import kumari.shweta.dto.ImmutableEntity;
import kumari.shweta.dto.PersonDTO;
import kumari.shweta.dto.UserDTO;
import kumari.shweta.dto.VersioningDTO;

public class AppTest {
	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		HibernateDAO<UserDTO> dao=HibernateDAO.getDAO(UserDTO.class);
        session.beginTransaction();
        
        UserDTO userDTO= new UserDTO();
        userDTO.setUserName("shweta");
        UserDTO userDTO2= dao.save(userDTO);
      
        
        
		/*
		 * Immutable Entity insert,update ,delete operation
		 *  No update operation on Immutable entity
		 */
        
       HibernateDAO<ImmutableEntity> immuDao = HibernateDAO.getDAO(ImmutableEntity.class);
       
       /*Save entity -> We can perfom save oprtation on Immutable entity */
       
      
         ImmutableEntity immutableEntity = new ImmutableEntity();
         immutableEntity.setAddress("BTM BLR");
         immutableEntity.setName("Alica");
         immuDao.save(immutableEntity);
       
       
       
       //Try update on immutable entity -->It doesn't throw any exception but it doesn't update entity 
       
       
          ImmutableEntity fechEntity = immuDao.find(1);
          fechEntity.setName("Cary");
          immuDao.update(fechEntity);
       
       
          /* Delete operation --> We can perform delete operation on Immutable entity*/
          // immuDao.delete(fechEntity);
       
       /*Reference of Mutable entity in Immutable entity  */
    
       ImmutableEntity immutableEntity3 = new ImmutableEntity();
       immutableEntity3.setAddress("PUNE");
       immutableEntity3.setName("Jackie");
       immutableEntity3.setUserDTO(userDTO2);
       ImmutableEntity immutableEntity1= immuDao.save(immutableEntity3);
       userDTO2.setUserName("Updated username");
       //UserDTO  has been updated with name -- So mutable reference can change  but relationship remains untouched  
       dao.update(userDTO2);
       String string= immutableEntity1.toString();
       System.out.println(string);
       
       
       //Immutable Collection Test
       HibernateDAO<HouseDTO> houseDao = HibernateDAO.getDAO(HouseDTO.class);
       HouseDTO houseDTO1= new HouseDTO();
        houseDTO1.setAddress("PNBE");
        houseDTO1.sethName("PLRD");
        houseDao.save(houseDTO1);
      
        HouseDTO houseDTO2= new HouseDTO();
        houseDTO2.setAddress("BLR");
        houseDTO2.sethName("BRGD");
        houseDao.save(houseDTO2);
        
        List<HouseDTO> list = new ArrayList<HouseDTO>();
        list.add(houseDTO1);
        list.add(houseDTO2);
        HibernateDAO<PersonDTO> personDao = HibernateDAO.getDAO(PersonDTO.class);
        PersonDTO personDTO = new PersonDTO();
        personDTO.setHouseDTO(list);
        personDTO.setName("FLORIK");
        PersonDTO fetchPersonDTO =  personDao.save(personDTO);
        
      
        /*Try to modify Immutable Collection (HouseDTO) of PersonDTO -->Exception occured :
        javax.persistence.PersistenceException: org.hibernate.HibernateException: changed an immutable collection instance: [kumari.shweta.dto.PersonDTO.HouseDTO#3]
        */
        /*
       
        HouseDTO houseDTO3= new HouseDTO();
        houseDTO3.sethName("INDIABULLS");
        houseDTO3.setAddress("MUMBAI");
        fetchPersonDTO.getHouseDTO().add(houseDTO3);
        personDao.update(fetchPersonDTO);
        
        */
        
        /*Test Versioning */
        
 
      HibernateDAO<VersioningDTO> versiondao =  HibernateDAO.getDAO(VersioningDTO.class);
     /* 
      VersioningDTO versioningDTO= new VersioningDTO();
      versioningDTO.setName("versioning_test1");
      versiondao.save(versioningDTO)
      
      */
      /*Note : If we update without changing any member of Entity class, It will not update version becoz Update query  won't run */
      VersioningDTO vdto=versiondao.find(10);
      vdto.setName("update versioning123");
      versiondao.update(vdto);
     
        
        
        
        
        
  }

}

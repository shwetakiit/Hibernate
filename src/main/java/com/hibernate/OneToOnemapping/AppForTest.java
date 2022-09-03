package com.hibernate.OneToOnemapping;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;

import com.hibernate.Inheritance.Vehicle;

public class AppForTest {
	
	public static void main(String[] args) {
	
		 AddressDTO address = new AddressDTO();
		 address.setAddressDetail("Bangalore");
		 
		 EmployeeDTO employeeDTO = new EmployeeDTO();
		 employeeDTO.setName("Shweta");
		 employeeDTO.setAddressDTO(address);
		
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory cfgFactory=cfg.buildSessionFactory();
	    Session session = cfgFactory.openSession();
	    session.beginTransaction();  
	    session.save(address);
	    session.save(employeeDTO);
	   
	    
	 
	    /*CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery criteriaQuery =
	            (CriteriaQuery) criteriaBuilder.createQuery(EmployeeDTO.class);
	    Root<EmployeeDTO> root = ((AbstractQuery<EmployeeDTO>) criteriaQuery).from(EmployeeDTO.class);
	    criteriaQuery.select(root).where(criteriaBuilder.like(root.get("addressDTO").get("addressDetail"), "Bangalore"));
	    */
	    session.getTransaction().commit();
	    session.close();
	    
	    
	    
	    
	}

}

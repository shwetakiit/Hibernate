package com.hibernate.hibernatepractice;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Inheritance.FourWheeler;
import com.hibernate.Inheritance.TwoWheeler;
import com.hibernate.Inheritance.Vehicle;
import com.hibernate.OneToOnemapping.AddressDTO;
import com.hibernate.OneToOnemapping.EmployeeDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory cfgFactory=cfg.buildSessionFactory();
    Session session = cfgFactory.openSession();
    session.beginTransaction();  
  
     VehicleDTO vehicle = new VehicleDTO();
    vehicle.setVehicleName("HIONDA");
    vehicle.setModelNo("110");
    
   // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   // LocalDateTime now = LocalDateTime.now();  
   // vehicle.setLaunchDate(dtf.format(now));
    
    TwoWheelerDTO twoWheeler = new TwoWheelerDTO();
    twoWheeler.setVehicleName("Bike");
    twoWheeler.setSteeringTwoWheeler("Bike Steering Handle");
    
    FourWheelerDTO fourWheeler = new FourWheelerDTO();
    fourWheeler.setVehicleName("Alto");
    fourWheeler.setSteeringFourWheeler("Alto Steering Wheel");
    
    VehicleDAO dao= VehicleDAO.getInstance();
    dao.save(vehicle);  
    
  FourWheelerDAO.getInstance().save(fourWheeler);
  TwoWheelerDAO.getInstance().save(twoWheeler);
    
    //Difference between get() and Load();
    
 
	//Add employeeDTO= (EmployeeDTO) session.get("EmployeeDTO", new Integer(2));
	//AddressDTO addressDTO=(AddressDTO) session.get(com.hibernate.OneToOnemapping.AddressDTO.class, new Integer(1));

  
 // twoWheeler.setSteeringTwoWheeler("changed");

  TwoWheelerDAO.getInstance().save(twoWheeler);
 // session.evict(twoWheeler);
  
  TwoWheelerDTO objDto = session.get(TwoWheelerDTO.class, 3);
  System.out.println(objDto);
  //here select query will not execute becoz already salect query has executed above 
  //so It will take from cache 
  TwoWheelerDTO objDto1 = session.get(TwoWheelerDTO.class, 3);
  System.out.println(objDto);
  
  
    	 
     }
}
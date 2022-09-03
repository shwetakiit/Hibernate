package com.hibernate.hibernatepractice;

public class VehicleDAO extends HibernateDAO<VehicleDTO> {
	
	
  //To make DAO class as singleton class used private access modifier
	
	private VehicleDAO() {

		super(VehicleDAO.class.toString());

	}
	
	/*
	 * Followed Singleton design pattern
	 *  private instance, so that it can be accessed by only by getInstance() method
	 */
	private static VehicleDAO vehicleDAO ;
	
	public static VehicleDAO getInstance() {
		if (vehicleDAO == null) {
			vehicleDAO = createDAO();
		}
		return vehicleDAO;
	}

	private static synchronized VehicleDAO createDAO() {

		if (vehicleDAO == null) {
			return new VehicleDAO();
		}
		return vehicleDAO;

	}

	
	

}

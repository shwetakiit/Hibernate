package com.hibernate.hibernatepractice;

public class FourWheelerDAO  extends HibernateDAO<FourWheelerDTO>  {

	private FourWheelerDAO() {

		super(FourWheelerDAO.class.toString());

	}
	
private static FourWheelerDAO fourWheelerDAO ;
	
	public static FourWheelerDAO getInstance() {
		if (fourWheelerDAO == null) {
			fourWheelerDAO = createDAO();
		}
		return fourWheelerDAO;
	}

	private static synchronized FourWheelerDAO createDAO() {

		if (fourWheelerDAO == null) {
			return new FourWheelerDAO();
		}
		return fourWheelerDAO;

	}
}

package com.hibernate.hibernatepractice;

public class TwoWheelerDAO extends HibernateDAO<TwoWheelerDTO> {
	
	
	private TwoWheelerDAO() {

		super(TwoWheelerDAO.class.toString());

	}
	
	/*
	 * Followed Singleton design pattern
	 *  private instance, so that it can be accessed by only by getInstance() method
	 */
	private static TwoWheelerDAO twoWheelerDAO ;
	
	public static TwoWheelerDAO getInstance() {
		if (twoWheelerDAO == null) {
			twoWheelerDAO = createDAO();
		}
		return twoWheelerDAO;
	}

	private static synchronized TwoWheelerDAO createDAO() {

		if (twoWheelerDAO == null) {
			return new TwoWheelerDAO();
		}
		return twoWheelerDAO;

	}
	

}

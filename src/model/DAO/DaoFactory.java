package model.DAO;

import model.DAO.impl.SellerDAOJdbc;

public class DaoFactory {
	public static SellerDAO createSellerDAO() {
		return new SellerDAOJdbc();
	}
}

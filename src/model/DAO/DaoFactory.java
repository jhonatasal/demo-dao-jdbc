package model.DAO;

import db.DB;
import model.DAO.impl.SellerDAOJdbc;

public class DaoFactory {
	public static SellerDAO createSellerDAO() {
		return new SellerDAOJdbc(DB.getConnection());
	}
}

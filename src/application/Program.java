package application;

import model.DAO.DaoFactory;
import model.DAO.SellerDAO;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDAO = DaoFactory.createSellerDAO();
		System.out.println(":::::Test 1: seller findById :::::");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
	}

}

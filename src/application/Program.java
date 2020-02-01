package application;

import java.util.List;

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
		
		System.out.println();
		
		System.out.println(":::::Test 1: seller findByDepartment :::::");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(dep);
		for(Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println();
		
		System.out.println(":::::Test 3: seller findAll :::::");
		list = sellerDAO.findAll();
		for(Seller sel : list) {
			System.out.println(sel);
		}
	}

}

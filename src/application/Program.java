package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.DAO.DaoFactory;
import model.DAO.SellerDAO;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		SellerDAO sellerDAO = DaoFactory.createSellerDAO();
		System.out.println(":::::Test 1: seller findById :::::");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println(":::::Test 2: seller findByDepartment :::::");
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
		
		System.out.println(":::::Test 4: seller Insert :::::");
		Seller newSeller = new Seller(null, "Greg","greg@gmail.com",new Date(),4000.0, dep);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New id =" + newSeller.getId());
		
		System.out.println(":::::Test 5: seller update :::::");
		seller = sellerDAO.findById(1);
		seller.setName("Martha Waine");
		sellerDAO.update(seller);
		System.out.println("Update completed");
		
		System.out.println(":::::Test 6: seller delete :::::");
		System.out.println("Digite o id que quer deletar: ");
		int id = sc.nextInt();
		sellerDAO.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}

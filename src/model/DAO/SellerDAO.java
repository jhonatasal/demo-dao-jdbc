package model.DAO;

import java.util.List;

import model.entites.Department;
import model.entites.Seller;

public interface SellerDAO {
	void insert(Seller obj);

	void update(Seller obj);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findAll();
	
	List<Seller> findByDepartment(Department department);
}

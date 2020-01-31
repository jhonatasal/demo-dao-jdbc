package model.DAO;

import java.util.List;

import model.entites.Department;
import model.entites.Seller;

public interface SellerDAO {
	void insert(Seller obj);

	void update(Seller obj);

	void deleteById(Integer id);

	Department findById(Integer id);

	List<Seller> findAll();
}

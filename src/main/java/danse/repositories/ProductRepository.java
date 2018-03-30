package danse.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import danse.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	@Transactional
	@Modifying
	@Query("update Product set id_colour = null where id_colour=?1")
	public void deleteColorOfProducts(Long id); 
}

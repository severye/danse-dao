package danse.repositories;

import org.springframework.data.repository.CrudRepository;

import danse.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}

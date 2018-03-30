package danse.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import danse.entities.SizeQuantity;

public interface SizeQuantityRepository extends CrudRepository<SizeQuantity, Long>{

	@Query("delete from size_quantity where id_product=?1 and id_size=?2")
	public void deleteSizeQuantity(Long idProduct, Long idSize);

	@Query("select sq from size_quantity sq where id_product=?1 and id_size=?2")
	public SizeQuantity getSizeQuantity(Long idProduct, Long idSize);
}

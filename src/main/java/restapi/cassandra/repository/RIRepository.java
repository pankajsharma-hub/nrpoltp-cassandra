package restapi.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import restapi.cassandra.model.RI_lookup;

public interface RIRepository extends CrudRepository<RI_lookup, String> {

	@Query("SELECT * from RI_lookup where batch_no in(?0) allow filtering")
	List<RI_lookup> findByBatch(String batch_no);

	@Query("SELECT * from RI_lookup where day in(?0) allow filtering")
	List<RI_lookup> findByDay(String day);
	
	@Query("SELECT * from RI_lookup where vaccine_id in(?0) allow filtering")
	List<RI_lookup> findByID(String vaccine_id);
	
	@Query("SELECT * from RI_lookup")
	List<RI_lookup> findAll();

}

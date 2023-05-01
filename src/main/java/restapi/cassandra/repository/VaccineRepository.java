package restapi.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import restapi.cassandra.model.vaccine_master;

public interface VaccineRepository extends CrudRepository<vaccine_master, String> {

	@Query("SELECT * from vaccine_master where vaccine_id in(?0)")
	vaccine_master findByID(String vaccine_id);

	@Query("SELECT * from vaccine_master")
	List<vaccine_master> findAll();

}

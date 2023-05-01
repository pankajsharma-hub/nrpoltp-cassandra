package restapi.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import restapi.cassandra.model.BiometricInfoChild;;

public interface BiometricRepository extends CrudRepository<BiometricInfoChild, String> {

	@Query("SELECT * from BiometricInfoChild where rch_child_id in(?0)")
	BiometricInfoChild findByID(String rch_child_id);

	@Query("SELECT * from BiometricInfoChild")
	List<BiometricInfoChild> findAll();

}

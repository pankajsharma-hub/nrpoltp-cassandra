package restapi.cassandra.repository;


import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import restapi.cassandra.model.child_migration;


public interface ChildMigrationRepository extends CassandraRepository<child_migration, String>{


	@Query("SELECT * from child_migration where rch_child_id in(?0)")
	List<child_migration> findUserByIdIn(String rch_child_id);
	
	@Query("SELECT * from child_migration")
	List<child_migration> findAll();
}

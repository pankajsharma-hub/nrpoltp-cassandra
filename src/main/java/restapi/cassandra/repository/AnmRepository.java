package restapi.cassandra.repository;


import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
import restapi.cassandra.model.anm_master;
 
public interface AnmRepository extends CrudRepository<anm_master, String> {
	
	@Query("SELECT * from anm_master where anm_id in(?0)")
	anm_master findUserByIdIn(String anm_id);
	
	@Query("SELECT * from anm_master where current_facility_id in(?0) allow filtering")
	List<anm_master> findUserByfacilityIdIn(String facility_id);
	
	@Query("SELECT * from anm_master")
	List<anm_master> findAll();
	
	
	@Query("SELECT current_facility_id from anm_master where anm_id in(?0)")
    anm_master findCurrentFacilityById(String anm_id);
}

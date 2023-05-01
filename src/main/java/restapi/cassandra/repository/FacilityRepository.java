package restapi.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import restapi.cassandra.model.facility_master;
 
public interface FacilityRepository extends CrudRepository<facility_master, String> {
	
	@Query("SELECT * from facility_master where facility_id in(?0)")
	facility_master findUserByIdIn(String facility_id);
	
	@Query("SELECT * from facility_master")
	List<facility_master> findAll();
	
	@Query("SELECT state from facility_master")
	List<String> findAllState();
	
	@Query("SELECT * from facility_master where state=?0 allow filtering")
	List<facility_master> findDistrict(String state);
	
	@Query("SELECT * from facility_master where state=?0 and district=?1 allow filtering")
	List<facility_master> findBlock(String state, String District);

	@Query("SELECT * from facility_master where state=?0 and district=?1 and block=?2 allow filtering")
	List<facility_master> findPhc(String state, String District, String Block);

	@Query("SELECT * from facility_master where state=?0 and district=?1 and block=?2 and phc=?3 allow filtering")
	List<facility_master> findSc(String state, String District, String Block, String Phc);

	@Query("SELECT * from facility_master where state=?0 and district=?1 and block=?2 and phc=?3 and sc=?4 allow filtering")
	List<facility_master> findVillage(String state, String District, String Block, String Phc, String Sc);

}


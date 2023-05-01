package restapi.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

import com.datastax.driver.core.LocalDate;

import restapi.cassandra.model.child_master;

public interface ChildRepository extends CrudRepository<child_master, String> {

	@Query("SELECT * from child_master")
	List<child_master> findAll();
	
	@Query("SELECT count(*) from child_master")
	long findCount();

	@Query("SELECT * from child_master limit 100")
	List<child_master> findTopChild();
	
	@Query("SELECT * from child_master_portal where rch_child_id=?0 allow filtering")
	child_master findByID(String rch_child_id);

	@Query("SELECT * from child_master where anm_id=?0 and next_vaccine_session1>=?1 and next_vaccine_session1<=?2 allow filtering;")
	List<child_master> workplan(String anm_id, LocalDate next_vaccine, LocalDate next_vaccine_session1);

	@Query("SELECT * from child_master where anm_id=?0 and next_vaccine_session1<?1 allow filtering;")
	List<child_master> duelist(String anm_id, LocalDate current_date);

	@Query("SELECT * from child_master_portal where anm_id=?0 allow filtering")
	List<child_master> findByAnmID(String anm_id);

	@Query("SELECT * from child_master where resident_state=?0 allow filtering")
	List<child_master> findDistrict(String state);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 allow filtering")
	List<child_master> findBlock(String state, String District);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 allow filtering")
	List<child_master> findPhc(String state, String District, String Block);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 allow filtering")
	List<child_master> findSc(String state, String District, String Block, String Phc);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 and resident_sc=?4 allow filtering")
	List<child_master> findVillage(String state, String District, String Block, String Phc, String Sc);
	
	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 and resident_sc=?4 and resident_village=?5 allow filtering")
	List<child_master> findVillageImmunization(String state, String District, String Block, String Phc, String Sc,String Village);

	
	//Due list by Facility

	@Query("SELECT * from child_master where resident_state=?0 and next_vaccine_session1<=?1 allow filtering")
	List<child_master> findDistrictDue(String state, LocalDate current_date);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and next_vaccine_session1<=?2 allow filtering")
	List<child_master> findBlockDue(String state, String District, LocalDate current_date);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and next_vaccine_session1<=?3 allow filtering")
	List<child_master> findPhcDue(String state, String District, String Block, LocalDate current_date);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 and next_vaccine_session1<=?4 allow filtering")
	List<child_master> findScDue(String state, String District, String Block, String Phc, LocalDate current_date);

	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 and resident_sc=?4 and next_vaccine_session1<=?5 allow filtering")
	List<child_master> findVillageDue(String state, String District, String Block, String Phc, String Sc, LocalDate current_date);
	
	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and resident_phc=?3 and resident_sc=?4 and resident_village=?5 and next_vaccine_session1<=?6 allow filtering")
	List<child_master> findVillageWiseDue(String state, String District, String Block, String Phc, String Sc, String Village,LocalDate current_date);

	
	@Query("SELECT * from child_master where resident_state=?0 and resident_district=?1 and resident_block=?2 and next_vaccine_session1>=?3 and next_vaccine_session1<=?4 allow filtering;")
	List<child_master> findPhcWorkplan(String selectState, String selectDistrict, String selectBlock,
			LocalDate start_date_local, LocalDate end_date_local);


}

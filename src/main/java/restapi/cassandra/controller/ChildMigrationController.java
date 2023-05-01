
package restapi.cassandra.controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.cassandra.model.anm_master;
import restapi.cassandra.model.child_master;
import restapi.cassandra.model.child_migration;
import restapi.cassandra.model.facility_master;
import restapi.cassandra.repository.ChildMigrationRepository;
import restapi.cassandra.repository.ChildRepository;
import restapi.cassandra.repository.FacilityRepository;
import restapi.cassandra.repository.AnmRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ChildMigrationController {

	@Autowired
	ChildMigrationRepository migration_repository;
	
	@Autowired
	ChildRepository child_repository;
	
	@Autowired
	FacilityRepository facility_repository;
	
	@Autowired
	AnmRepository anm_repository;
	

	@GetMapping("/child_migration")
	public List<child_migration> getAllMigration() {
		System.out.println("Get all Customers...");

		List<child_migration> a = migration_repository.findAll();
		System.out.println(a);
		return a;
	}
	
	@GetMapping("/child_migration/{child_id}")
	public List<child_migration> getMigrationByID(@PathVariable String child_id) {
		System.out.println("Get all Migration History By Child ID...");

		List<child_migration> a = migration_repository.findUserByIdIn(child_id);
		System.out.println(a);
		return a;
	}
	
	@PostMapping("/migration/{child_id}/{current_date}/{new_facility}/{anm_id}")
	public ResponseEntity<child_migration> postMigration(@PathVariable String child_id,@PathVariable String current_date,@PathVariable String new_facility,@PathVariable String anm_id, @RequestBody child_migration requestChildMigration) throws ParseException {
		System.out.println(requestChildMigration + "Migration Details-"+child_id +","+current_date + ","+ new_facility);
				
		//facility_master
		facility_master facility=facility_repository.findUserByIdIn(new_facility);	
		
		System.out.println("Facility_details:"+facility);
	
		//child_master
		child_master child=child_repository.findByID(child_id);
		String old_id=child.getResidentFacilityId();
		String old_anm_id=child.getAnmId();
		
		//anm_master
		anm_master anm_detail=anm_repository.findUserByIdIn(anm_id);
		
		System.out.println("ANM_details:"+anm_detail);
				
		child.setResidentFacilityId(new_facility);
		child.setResidentState(facility.getState());
		child.setResidentBlock(facility.getBlock());
		child.setResidentDistrict(facility.getDistrict());
		child.setResidentPhc(facility.getPhc());
		child.setResidentSc(facility.getSc());
		child.setResidentVillage(facility.getVillage());
		child.setAnmId(anm_detail.getId());
		child.setAnmMobile(anm_detail.getMobile());
		child.setAnmName(anm_detail.getName());
		
		
		child.setHistoryId(current_date,old_anm_id, old_id);
				
		
		child_repository.save(child);
		

		
		//child_migration		
		child_migration a=new child_migration();
		a.setId(child_id);
		a.setDate(current_date);
		a.setMigrating(old_id);
		child_migration _requestChildMigration = migration_repository.save(a);
		
		return new ResponseEntity<>(_requestChildMigration, HttpStatus.OK);
	}

}
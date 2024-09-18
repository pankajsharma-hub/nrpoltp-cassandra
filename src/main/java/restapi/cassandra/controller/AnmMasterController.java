package restapi.cassandra.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import restapi.cassandra.model.anm_master;
import restapi.cassandra.repository.AnmRepository;
 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnmMasterController {
 
  @Autowired
  AnmRepository anm_repository;
  
  @GetMapping("/anm_details")
  public List<anm_master> getAllCustomers() {
    System.out.println("Get all Customers...");
      
    List<anm_master> a= anm_repository.findAll();
    System.out.println(a);
    return a;
  }
 
   
  @GetMapping("anm_details/facility/{anm_id}")
  public anm_master findFacilityById(@PathVariable String anm_id) {
	 System.out.println("Get ANM Current facility Details - "+anm_id);
     anm_master a=anm_repository.findCurrentFacilityById(anm_id);
     System.out.println(a);
     return a;
  }
  
  
  @GetMapping("anm_details/{anm_id}")
  public anm_master findById(@PathVariable String anm_id) {
	 System.out.println("Get ANM Details - "+anm_id);
     anm_master a=anm_repository.findUserByIdIn(anm_id);
     System.out.println(a);
     return a;
  }
    
  @GetMapping("anm_details/facilityId/{facility_id}")
  public List<anm_master> findByFacilityId(@PathVariable String facility_id) {
	 System.out.println("Get ANM Details - "+facility_id);
	 List<anm_master> a=anm_repository.findUserByfacilityIdIn(facility_id);
     System.out.println(a);
     return a;
  }
  
}
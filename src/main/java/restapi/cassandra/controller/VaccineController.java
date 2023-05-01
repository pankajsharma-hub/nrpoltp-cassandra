package restapi.cassandra.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import restapi.cassandra.model.vaccine_master;
import restapi.cassandra.repository.VaccineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VaccineController {

  @Autowired
  VaccineRepository vaccine_repository;

  @GetMapping("/vaccine")
  public List<vaccine_master> getAllVaccine() {
    System.out.println("Get all Vaccine...");

    List<vaccine_master> a= vaccine_repository.findAll();
    System.out.println(a);
    return a;
  }


  @GetMapping("vaccine_details/{vaccine_id}")
  public vaccine_master findById(@PathVariable String vaccine_id) {
	 System.out.println("Get Vaccine Details - "+vaccine_id);
     vaccine_master a=vaccine_repository.findByID(vaccine_id);
     System.out.println(a);
     return a;
  }


}

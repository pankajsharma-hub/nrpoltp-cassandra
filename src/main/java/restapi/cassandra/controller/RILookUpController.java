package restapi.cassandra.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import restapi.cassandra.model.RI_lookup;
import restapi.cassandra.repository.RIRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RILookUpController {

  @Autowired
  RIRepository RI_repository;

  @GetMapping("/RI")
  public List<RI_lookup> getAllRI() {
    System.out.println("Get all RI...");

    List<RI_lookup> a= RI_repository.findAll();
    System.out.println(a);
    return a;
  }


  @GetMapping("RI/vaccine/{vaccine_id}")
  public List<RI_lookup> findById(@PathVariable String vaccine_id) {
	 System.out.println("Get Combination Vaccine - "+vaccine_id);
	 List<RI_lookup> a=RI_repository.findByID(vaccine_id);
     System.out.println(a);
     return a;
  }

  @GetMapping("RI/batch/{no}")
  public List<RI_lookup> findByBatch(@PathVariable int no) {
	 System.out.println("Get Combination Vaccine - "+no);
	 String batch_no=Integer.toString(no);
	 List<RI_lookup> a=RI_repository.findByBatch(batch_no);
     System.out.println(a);
     return a;
  }
  
  @GetMapping("RI/day/{day}")
  public List<RI_lookup> findByDay(@PathVariable String day) {
	 System.out.println("Get Combination Vaccine - "+day);
	 List<RI_lookup> a=RI_repository.findByDay(day);
     System.out.println(a);
     return a;
  }

}

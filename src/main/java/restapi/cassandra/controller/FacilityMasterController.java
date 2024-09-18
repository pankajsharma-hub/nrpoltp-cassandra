package restapi.cassandra.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.cassandra.model.anm_master;
import restapi.cassandra.model.facility_master;
import restapi.cassandra.repository.FacilityRepository;
import restapi.cassandra.repository.AnmRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FacilityMasterController {

	@Autowired
	FacilityRepository facility_repository;

	
	@Autowired
	AnmRepository anm_repository;

		@GetMapping("/facility_master")
	public List<facility_master> getAllFacility() {
		System.out.println("Get all Facility...");

		List<facility_master> a = facility_repository.findAll();
		System.out.println(a);
		return a;
	}

	
	@GetMapping("facility_master/{selectState}")
	public List<facility_master> getAllDistrict(@PathVariable String selectState) {
		System.out.println("Get all District under " + selectState);
		List<facility_master> a = facility_repository.findDistrict(selectState);
		System.out.println(a);
		return a;
	}

	@GetMapping("facility_master/{selectState}/{selectDistrict}")
	public List<facility_master> getBlock(@PathVariable String selectState, @PathVariable String selectDistrict)
			throws ParseException {
		System.out.println("Get Block List - " + selectDistrict);
		List<facility_master> c = facility_repository.findBlock(selectState, selectDistrict);
		System.out.println(c);
		return c;
	}
	
	@GetMapping("facility_master/{selectState}/{selectDistrict}/{selectBlock}")
	public List<facility_master> getPhc(@PathVariable String selectState, @PathVariable String selectDistrict,@PathVariable String selectBlock)
			throws ParseException {
		System.out.println("Get Phc List - " + selectBlock);
		List<facility_master> c = facility_repository.findPhc(selectState, selectDistrict, selectBlock);
		System.out.println(c);
		return c;
	}
	@GetMapping("facility_master/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}")
	public List<facility_master> getSc(@PathVariable String selectState, @PathVariable String selectDistrict,@PathVariable String selectBlock,@PathVariable String selectPhc)
			throws ParseException {
		System.out.println("Get Sc List - " + selectPhc);
		List<facility_master> c = facility_repository.findSc(selectState, selectDistrict,selectBlock,selectPhc);
		System.out.println(c);
		return c;
	}
	@GetMapping("facility_master/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{selectSc}")
	public List<facility_master> getVillage(@PathVariable String selectState, @PathVariable String selectDistrict,@PathVariable String selectBlock,@PathVariable String selectPhc,@PathVariable String selectSc)
			throws ParseException {
		System.out.println("Get Block List - " + selectDistrict);
		List<facility_master> c = facility_repository.findVillage(selectState, selectDistrict,selectBlock,selectPhc,selectSc);
		System.out.println(c);
		return c;
	}

	
	@GetMapping("facility_master/anmId/{anmId}")
	public facility_master getFacility(@PathVariable String anmId) {
		System.out.println("Get Facility Details under ANM:" + anmId);
		anm_master anm=anm_repository.findUserByIdIn(anmId);
		String facility_id=anm.getFacilityId();
		facility_master a = facility_repository.findUserByIdIn(facility_id);
		System.out.println(a);
		return a;
	}
	
	@GetMapping("facility_master/facility/{facility_id}")
	public facility_master getFacilityDetails(@PathVariable String facility_id) {
		facility_master a = facility_repository.findUserByIdIn(facility_id);
		System.out.println(a);
		return a;
	}
	
}
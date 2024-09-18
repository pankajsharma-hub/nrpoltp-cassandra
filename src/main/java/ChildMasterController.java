

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.datastax.driver.core.LocalDate;
import restapi.cassandra.model.child_master;
import restapi.cassandra.repository.ChildRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ChildMasterController {

	@Autowired
	ChildRepository child_repository;
	

	@GetMapping("/child")
	public List<child_master> getAllChild() {
		System.out.println("Get all Customers...");

		List<child_master> a = child_repository.findAll();
		System.out.println(a);
		return a;
	}

	@GetMapping("workplan/{anm_id}/{start_date}/{end_date}")
	public List<child_master> workplan(@PathVariable String anm_id, @PathVariable String start_date,
			@PathVariable String end_date) throws ParseException {
		System.out.println("Get ANM Workplan - " + anm_id);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(start_date);
		LocalDate start_date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		

		Date d2 = formatter.parse(end_date);
		LocalDate end_date_local = LocalDate.fromMillisSinceEpoch(d2.getTime());
		System.out.println("StartDate: "+start_date_local+ "End Date:"+end_date_local);

		List<child_master> c = child_repository.workplan(anm_id, start_date_local, end_date_local);

		System.out.println(c);
		return c;
	}

	@GetMapping("duelist/{anm_id}/{current_date}")
	public List<child_master> duelist(@PathVariable String anm_id, @PathVariable String current_date)
			throws ParseException {
		System.out.println("Get ANM Due List - " + anm_id);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		System.out.println("date_local: "+ date_local);


		List<child_master> c = child_repository.duelist(anm_id, date_local);

		System.out.println(c);
		return c;
	}

	@GetMapping("child_detail/{rch_child_id}")
	public child_master findByID(@PathVariable String rch_child_id) {
		System.out.println("Get Child Details - " + rch_child_id);
		child_master a = child_repository.findByID(rch_child_id);
		System.out.println(a);
		return a;
	}

	@GetMapping("child_details/anm/{anm_id}")
	public List<child_master> findByAnmID(@PathVariable String anm_id) {
		System.out.println("Get Child Details for anm - " + anm_id);
		List<child_master> a = child_repository.findByAnmID(anm_id);
		System.out.println("next_vaccine_session1: ");
		System.out.println(a);
		return a;
	}

	@GetMapping("child_details/{selectState}")
	public List<child_master> getAllDistrict(@PathVariable String selectState) {
		System.out.println("Get all District under " + selectState);
		List<child_master> a = child_repository.findDistrict(selectState);
		System.out.println(a);
		return a;
	}

	@GetMapping("child_details/{selectState}/{selectDistrict}")
	public List<child_master> getBlock(@PathVariable String selectState, @PathVariable String selectDistrict)
			throws ParseException {
		System.out.println("Get Block List - " + selectDistrict);
		List<child_master> c = child_repository.findBlock(selectState, selectDistrict);
		System.out.println(c);
		return c;
	}

	@GetMapping("child_details/{selectState}/{selectDistrict}/{selectBlock}")
	public List<child_master> getPhc(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock) throws ParseException {
		System.out.println("Get Phc List - " + selectBlock);
		List<child_master> c = child_repository.findPhc(selectState, selectDistrict, selectBlock);
		System.out.println(c);
		return c;
	}

	@GetMapping("child_details/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}")
	public List<child_master> getSc(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc) throws ParseException {
		System.out.println("Get Sc List - " + selectPhc);
		List<child_master> c = child_repository.findSc(selectState, selectDistrict, selectBlock, selectPhc);
		System.out.println(c);
		return c;
	}
	
	@GetMapping("child_details/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{selectSc}")
	public List<child_master> getVillage(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc, @PathVariable String selectSc) throws ParseException {
		System.out.println("Get Village List - " + selectSc);
		List<child_master> c = child_repository.findVillage(selectState, selectDistrict, selectBlock, selectPhc,selectSc);
		System.out.println(c);
		return c;
	}

	@GetMapping("child_details/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{selectSc}/{selectVillage}")
	public List<child_master> getVillage(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc, @PathVariable String selectSc, @PathVariable String selectVillage)
			throws ParseException {
		System.out.println("Get selectVillage - " + selectVillage);
		List<child_master> c = child_repository.findVillageImmunization(selectState, selectDistrict, selectBlock, selectPhc,
				selectSc,selectVillage);
		System.out.println(c);
		return c;
	}

	// Due list

	@GetMapping("duelist/facility/{selectState}/{current_date}")
	public List<child_master> duelistDistrict(@PathVariable String selectState, @PathVariable String current_date) throws ParseException {
		System.out.println("Get all District under " + selectState);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> a = child_repository.findDistrictDue(selectState, date_local);
		System.out.println(a);
		return a;
	}

	@GetMapping("duelist/facility/{selectState}/{selectDistrict}/{current_date}")
	public List<child_master> duelistBlock(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String current_date) throws ParseException {
		System.out.println("Get Block List - " + selectDistrict);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> c = child_repository.findBlockDue(selectState, selectDistrict,date_local);
		System.out.println(c);
		return c;
	}

	@GetMapping("duelist/facility/{selectState}/{selectDistrict}/{selectBlock}/{current_date}")
	public List<child_master> duelistPhc(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String current_date) throws ParseException {
		System.out.println("Get Phc List - " + selectBlock);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> c = child_repository.findPhcDue(selectState, selectDistrict, selectBlock,date_local);
		System.out.println(c);
		return c;
	}

	@GetMapping("duelist/facility/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{current_date}")
	public List<child_master> duelistSc(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc, @PathVariable String current_date)
			throws ParseException {
		System.out.println("Get Sc List - " + selectPhc);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> c = child_repository.findScDue(selectState, selectDistrict, selectBlock, selectPhc,date_local);
		System.out.println(c);
		return c;
	}

	@GetMapping("duelist/facility/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{selectSc}/{current_date}")
	public List<child_master> duelistVillage(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc, @PathVariable String selectSc,
			@PathVariable String current_date) throws ParseException {
		System.out.println("Get Block List - " + selectDistrict);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> c = child_repository.findVillageDue(selectState, selectDistrict, selectBlock, selectPhc,
				selectSc,date_local);
		System.out.println(c);
		return c;
	}
	
	@GetMapping("duelist/facility/{selectState}/{selectDistrict}/{selectBlock}/{selectPhc}/{selectSc}/{selectVillage}/{current_date}")
	public List<child_master> duelistVillage(@PathVariable String selectState, @PathVariable String selectDistrict,
			@PathVariable String selectBlock, @PathVariable String selectPhc, @PathVariable String selectSc,@PathVariable String selectVillage,
			@PathVariable String current_date) throws ParseException {
		System.out.println("Get selectVillage List - " + selectVillage);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = formatter.parse(current_date);
		LocalDate date_local = LocalDate.fromMillisSinceEpoch(d1.getTime());
		List<child_master> c = child_repository.findVillageWiseDue(selectState, selectDistrict, selectBlock, selectPhc,
				selectSc,selectVillage,date_local);
		System.out.println(c);
		return c;
	}

	@PostMapping(path = "/api/child", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<child_master> saveNewChildInfo(@RequestBody List<child_master> c) {
		child_repository.saveAll(c);
		return c;
	}

}

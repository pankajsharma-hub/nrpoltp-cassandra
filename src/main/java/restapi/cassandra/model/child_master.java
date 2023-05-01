package restapi.cassandra.model;


import java.util.HashMap;
import java.util.Map;

//import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.datastax.driver.core.LocalDate;


@UserDefinedType
class vaccine {
	private String date_at;
	private String weight_at_vaccination;
	private String anm_id_at_vaccination;
	private String facility_id;

	public String getDateAtVaccination() {
		return date_at;
	}

	public String getWeightAtVaccination() {
		return weight_at_vaccination;
	}

	public String getAnmIdAtVaccination() {
		return anm_id_at_vaccination;
	}

	public String getFacilityId() {
		return facility_id;
	}

}

@UserDefinedType
class old_data {
	private String anm_id;
	private String facility_id;

	public String getAnmId() {
		return anm_id;
	}

	public String getFacilityId() {
		return facility_id;
	}

	public void setAnmId(String anmId) {
		this.anm_id = anmId;
	}

	public void setFacilityId(String facilityId) {
		this.facility_id = facilityId;
	}

}

@Table("child_master")
public class child_master {

	@PrimaryKey
	private String rch_child_id;

	private String rch_mother_id;
	private String anm_id;
	private String anm_name;
	private String anm_mobile;
	private Float birth_weight;
	private String child_dob;
	private String child_name;
	private String child_sex;
	private String delivery_facility_id;
	private String enrollment_date;
	private String father_mobile;
	private String father_name;
	private String mother_mobile;
	private String mother_name;
	private String resident_block;
	private String resident_district;
	private String resident_facility_id;
	private String resident_phc;
	private String resident_sc;
	private String resident_state;
	private String resident_village;

	private vaccine v1;
	private vaccine v2;
	private vaccine v3;
	private vaccine v4;
	private vaccine v5;
	private vaccine v6;
	private vaccine v7;
	private vaccine v8;
	private vaccine v9;
	private vaccine v10;
	private vaccine v11;
	private vaccine v12;
	private vaccine v13;
	private vaccine v14;
	private vaccine v15;
	private vaccine v16;
	private vaccine v17;
	private vaccine v18;
	private vaccine v19;
	private vaccine v20;
	private vaccine v21;

	private String next_vaccine_id;
	// private LocalDate next_vaccine_session1;
	//private String next_vaccine_session1;
	private String next_vaccine_session_text;
	private LocalDate next_vaccine_session1;
	

	private Map<String, String> history_anm_facility_id;

	public child_master() {
	}

	public String getId() {
		System.out.println("Rch Child ID: " + rch_child_id);
		return rch_child_id;
	}

	public String getMotherId() {
		return rch_mother_id;
	}

	public String getAnmId() {
		return anm_id;
	}

	public String getAnmMobile() {
		return anm_mobile;
	}

	public String getAnmName() {
		return anm_name;
	}

	public Float getBirthWeight() {
		return birth_weight;
	}

	public String getDob() {
		return child_dob;
	}

	public String getName() {
		return child_name;
	}

	public String getSex() {
		return child_sex;
	}

	public String getDeliveryFacilityId() {
		return delivery_facility_id;
	}

	public String getEnrollmentDate() {
		return enrollment_date;
	}

	public String getFatherMobile() {
		return father_mobile;
	}

	public String getFatherName() {
		return father_name;
	}

	public String getMotherMobile() {
		return mother_mobile;
	}

	public String getMotherName() {
		return mother_name;
	}

	public String getResidentFacilityId() {
		return resident_facility_id;
	}

	public String getResidentState() {
		return resident_state;
	}

	public String getResidentDistrict() {
		return resident_district;
	}

	public String getResidentBlock() {
		return resident_block;
	}

	public String getResidentPhc() {
		return resident_phc;
	}

	public String getResidentSc() {
		return resident_sc;
	}

	public String getResidentVillage() {
		return resident_village;
	}

	public vaccine getVaccine1() {
		return v1;
	}

	public vaccine getVaccine2() {
		return v2;
	}

	public vaccine getVaccine3() {
		return v3;
	}

	public vaccine getVaccine4() {
		return v4;
	}

	public vaccine getVaccine5() {
		return v5;
	}

	public vaccine getVaccine6() {
		return v6;
	}

	public vaccine getVaccine7() {
		return v7;
	}

	public vaccine getVaccine8() {
		return v8;
	}

	public vaccine getVaccine9() {
		return v9;
	}

	public vaccine getVaccine10() {
		return v10;
	}

	public vaccine getVaccine11() {
		return v11;
	}

	public vaccine getVaccine12() {
		return v12;
	}

	public vaccine getVaccine13() {
		return v13;
	}

	public vaccine getVaccine14() {
		return v14;
	}

	public vaccine getVaccine15() {
		return v15;
	}

	public vaccine getVaccine16() {
		return v16;
	}

	public vaccine getVaccine17() {
		return v17;
	}

	public vaccine getVaccine18() {
		return v18;
	}

	public vaccine getVaccine19() {
		return v19;
	}

	public vaccine getVaccine20() {
		return v20;
	}

	public vaccine getVaccine21() {
		return v21;
	}

	public String getNextVaccine() {
		return next_vaccine_id;
	}

	public Map<String, String> getHistoryAnmFacility() {
		return history_anm_facility_id;
	}

	
	
	public LocalDate getNextVaccineDate()  {

		return next_vaccine_session1;
	}
	
	public String getNextVaccineDateString()  {

		return next_vaccine_session_text;
	}
	

	public void setResidentFacilityId(String input) {
		this.resident_facility_id = input;
	}

	public void setResidentState(String input) {
		this.resident_state = input;
	}

	public void setResidentDistrict(String input) {
		this.resident_district = input;
	}

	public void setResidentBlock(String input) {
		this.resident_block = input;
	}

	public void setResidentPhc(String input) {
		this.resident_phc = input;
	}

	public void setResidentSc(String input) {
		this.resident_sc = input;
	}

	public void setResidentVillage(String input) {
		this.resident_village = input;
	}

	public void setAnmId(String input) {
		this.anm_id = input;
	}

	public void setAnmMobile(String input) {
		this.anm_mobile = input;
	}

	public void setAnmName(String input) {
		this.anm_name = input;
	}

	public void setHistoryId(String current_date, String anmId, String facilityId) {

		if (this.history_anm_facility_id == null) {
			this.history_anm_facility_id = new HashMap<String, String>();
		}
		String str = "{anm_id: " + anmId + ",facility_id: " + facilityId + "}";
		this.history_anm_facility_id.put(current_date, str);
		System.out.println("5" + this.history_anm_facility_id);
	}

	@Override
	public String toString() {
		return "child_master [rch_child_id=" + rch_child_id + ", child_name=" + child_name + ", next_vaccine="
				+ next_vaccine_id + ", next_vaccine_date= " + next_vaccine_session1 + "]";
	}
}

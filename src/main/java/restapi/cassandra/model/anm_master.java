package restapi.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("anm_master")
public class anm_master {

	@PrimaryKey
	private String anm_id;

	private String anm_name;
	private String anm_address;
	private String anm_mobile;
	private String current_facility_id;
	private String join_date;

	public anm_master() {
	}

	// Get the ANM Details
	public String getId() {
		return anm_id;
	}

	public String getName() {
		return anm_name;
	}

	public String getAddress() {
		return anm_address;
	}

	public String getMobile() {
		return anm_mobile;
	}

	public String getFacilityId() {
		return current_facility_id;
	}

	public String getJoinDate() {
		return join_date;
	}

// To Set the Facility ID for ANM

	public void setFacilityId(String FacilityId) {
		this.current_facility_id = FacilityId;
	}

	@Override
	public String toString() {
		return "anm_master [anm_id=" + anm_id + ", anm_name=" + anm_name + ", anm_mobile=" + anm_mobile + ", anm_address= " + anm_address + "]";
	}

}
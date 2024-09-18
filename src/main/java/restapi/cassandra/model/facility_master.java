package restapi.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class facility_master {

	@PrimaryKey
	private String facility_id;

	private String facility_name;
	private String facility_type;
	private String state;
	private String district;
	private String block;
	private String phc;
	private String sc;
	private String village;

	public facility_master() {
	}
	
	public String getFacilityId() {
		return facility_id;
	}
	public String getFacilityName() {
		return facility_name;
	}
	public String getFacilityType() {
		return facility_type;
	}
	public String getState() {
		return state;
	}
	public String getDistrict() {
		return district;
	}
	public String getBlock() {
		return block;
	}
	public String getPhc() {
		return phc;
	}
	public String getSc() {
		return sc;
	}
	public String getVillage() {
		return village;
	}
	
	@Override
	public String toString() {
		return "facility_master [facility_id=" + facility_id + ", facility_name=" + facility_name + ", facility_type=" + facility_type + ", state= " + state + "]";
	}
}

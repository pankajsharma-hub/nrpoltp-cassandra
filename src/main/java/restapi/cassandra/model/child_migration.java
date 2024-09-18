package restapi.cassandra.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class child_migration {
	
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0,name = "rch_child_id")
	private String rch_child_id;

	@PrimaryKeyColumn(name = "date_of_migration")
	private String date_of_migration;
	
	private String migrating_facility_id;
	private String anm_id;
	private String anm_name;
	private String new_anm_id;
	private String new_anm_name;
	private String new_facility_id;

	public child_migration() {
	}

	// Get the Child_migration Details
	public String getId() {
		return rch_child_id;
	}

	public String getDate() {
		return date_of_migration;
	}

	public String getMigrating() {
		return migrating_facility_id;
	}
	public String getAnmId() {
		return anm_id;
	}
	public String getAnmName() {
		return anm_name;
	}
	
	public void setId(String id) {
		this.rch_child_id=id;
	}
	public String getNewAnmId() {
		return new_anm_id;
	}
	public String getNewAnmName() {
		return new_anm_name;
	}
	public String getNewFacilityId() {
		return new_facility_id;
	}
		

	public void setDate(String current_date) {
		this.date_of_migration=current_date;
	}

	public void setMigrating(String new_facility_id) {
		this.migrating_facility_id=new_facility_id;
	}
	
	public void setAnmId(String anmId)
	{
		this.anm_id=anmId;
	}
	public void setAnmName(String anmName) {
		this.anm_name=anmName;
	}
	
	public void setNewAnmId(String anmId)
	{
		this.new_anm_id=anmId;
	}
	public void setNewAnmName(String anmName) {
		this.new_anm_name=anmName;
	}
	
	public void setNewFacilityId(String new_facility_id) {
		this.new_facility_id=new_facility_id;
	}
	
	@Override
	public String toString() {
		return "migration_child [rch_child_id=" + rch_child_id + ", date_of_migration=" + date_of_migration + ", migrating_facility_id=" + migrating_facility_id + "]";
	}

}

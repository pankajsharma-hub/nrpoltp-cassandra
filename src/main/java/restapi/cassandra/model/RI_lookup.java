
package restapi.cassandra.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class RI_lookup {
	
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0,name = "batch_no")
	private String batch_no;

	@PrimaryKeyColumn(name = "day")
	private String day;
	
	@PrimaryKeyColumn(name = "vaccine_id")
	private String vaccine_id;
	
	private String vaccine_name;
	
	public RI_lookup() {
	}

	// Get the Child_migration Details
	public String getBatch() {
		return batch_no;
	}

	public String getDay() {
		return day;
	}

	public String getVaccineId() {
		return vaccine_id;
	}
	
	public String getVaccineName() {
		return vaccine_name;
	}
		
	@Override
	public String toString() {
		return "RI Details [batch_no=" + batch_no + ", day=" + day + ", vaccine_id=" + vaccine_id + ", vaccine_name=" + vaccine_name+"]";
	}

}

package restapi.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class vaccine_master {

	@PrimaryKey
	private String vaccine_id;

	private String vaccine_name;

	public vaccine_master() {
	}

	// Get the Child_migration Details
	public String getId() {
		return vaccine_id;
	}

	public String getName() {
		return vaccine_name;
	}

	@Override
	public String toString() {
		return "vaccine_master [vaccine_id=" + vaccine_id + ", vaccine_name=" + vaccine_name + "]";
	}

}

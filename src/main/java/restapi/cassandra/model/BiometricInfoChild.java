package restapi.cassandra.model;



import java.nio.ByteBuffer;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class BiometricInfoChild {

	@PrimaryKey
	private String rch_child_id;

	private ByteBuffer left_palm;
	private ByteBuffer right_palm;
	private ByteBuffer left_foot;
	private ByteBuffer right_foot;
	private ByteBuffer left_thumb;

	public BiometricInfoChild() {
	}

	// Get the Child_migration Details
	public String getId() {
		return rch_child_id;
	}

	public ByteBuffer getLeftPalm() {
		return left_palm;
	}
	public ByteBuffer getRightPalm() {
		return right_palm;
	}
	public ByteBuffer getLeftFoot() {
		return left_foot;
	}
	public ByteBuffer getRightFoot() {
		return right_foot;
	}
	public ByteBuffer getLeftThumb() {
		return left_thumb;
	}
	
	public void setId(String input) {
		this.rch_child_id=input;
	}

	public void setLeftPalm(ByteBuffer input) {
		this.left_palm=input;
	}
	public void setRightPalm(ByteBuffer input) {
		this.right_palm=input;
	}
	public void setLeftFoot(ByteBuffer input) {
		this.left_foot=input;
	}
	public void setRightFoot(ByteBuffer input) {
		this.right_foot=input;
	}
	public void setLeftThumb(ByteBuffer input) {
		this.left_thumb=input;
	}
	
	@Override
	public String toString() {
		return "BiometricInfoChild [rch_child_id=" + rch_child_id + ", left_thumb=" + left_thumb + "]";
	}

}

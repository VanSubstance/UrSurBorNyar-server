package com.my.ursurbornyar.vo;

public class PointSet {
	public PointSet(String id, String start_point_id, String end_point_id) {
		super();
		this.id = id;
		this.start_point_id = start_point_id;
		this.end_point_id = end_point_id;
	}


	private String id;
	private String start_point_id;
	private String end_point_id;
	
	
	@Override
	public String toString() {
		return "PointSet [id=" + id + ", start_point_id=" + start_point_id + ", end_point_id=" + end_point_id + "]";
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getStart_point_id() {
		return start_point_id;
	}


	public void setStart_point_id(String start_point_id) {
		this.start_point_id = start_point_id;
	}


	public String getEnd_point_id() {
		return end_point_id;
	}


	public void setEnd_point_id(String end_point_id) {
		this.end_point_id = end_point_id;
	}
	
	
}

package com.my.ursurbornyar.vo;

public class Path {
	private String id;
	private String start_point_id;
	private String end_point_id;
	
	public String toString() {
		return "{\n" + "\tid : " + id + "\n" + "\tstart point id : " + start_point_id + "\tend point id" + end_point_id +"\n" + "}";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getStartId() {
		return start_point_id;
	}

	public void setStartId(String id) {
		this.start_point_id = id;
	}
	
	public String getEndId() {
		return end_point_id;
	}
	
	public void setEndId(String id) {
		this.end_point_id = id;
	}

}

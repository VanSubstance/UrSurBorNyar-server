package com.my.ursurbornyar.vo;

import java.util.HashMap;

public class Path {
	private String id;
	private String name;
	private String start_place_id;
	private String end_place_id;
	
	public String toString() {
		return "{\n" + "\tid : " + id + "\n" + "\tname : " + name + "\n" + "\tstart place id : " + start_place_id + "\tend place id" + end_place_id +"\n" + "}";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_place_id() {
		return start_place_id;
	}

	public void setStart_place_id(String start_place_id) {
		this.start_place_id = start_place_id;
	}

	public String getEnd_place_id() {
		return end_place_id;
	}

	public void setEnd_place_id(String end_place_id) {
		this.end_place_id = end_place_id;
	}

}

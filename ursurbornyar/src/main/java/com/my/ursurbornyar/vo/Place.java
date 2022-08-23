package com.my.ursurbornyar.vo;

import java.util.HashMap;

public class Place {
	private String id;
	private String name;
	private Coordinate coor;

	public Place() {
		super();
	}

	public Place(HashMap<String, Object> place) {
		this.id = (String) place.get("id");
		this.name = (String) place.get("name");
		this.coor = new Coordinate((HashMap<String, Double>) place.get("coor"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getCoordinate() {
		return coor;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coor = coordinate;
	}

	public String toString() {
		return "\nid::\t" + id + "\nname::\t " + name + "\ncoor::\t" + coor;
	}
}

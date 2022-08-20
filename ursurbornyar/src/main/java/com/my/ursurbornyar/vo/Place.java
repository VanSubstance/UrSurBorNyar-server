package com.my.ursurbornyar.vo;

public class Place {
	private String id;
	private String name;
	private Coordinate coor;

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
}

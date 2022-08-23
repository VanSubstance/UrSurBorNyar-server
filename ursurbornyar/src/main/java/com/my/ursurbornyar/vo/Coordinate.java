package com.my.ursurbornyar.vo;

import java.util.HashMap;

public class Coordinate {
	private double x;
	private double y;

	public Coordinate() {
		super();
	}

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate(HashMap<String, Double> coor) {
		this.x = coor.get("x");
		this.y = coor.get("y");
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "\nx::\t" + x + "\ny::\t" + y + "\n";
	}

}

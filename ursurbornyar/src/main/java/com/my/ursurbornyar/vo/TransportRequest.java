package com.my.ursurbornyar.vo;

public class TransportRequest {
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	public TransportRequest() {
		super();
	}
	
	public TransportRequest(Coordinate startCoor, Coordinate endCoor) {
		this.startX = startCoor.getX();
		this.startY = startCoor.getY();
		this.endX = endCoor.getX();
		this.endY = endCoor.getY();
	}

	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public double getStartY() {
		return startY;
	}

	public void setStartY(double startY) {
		this.startY = startY;
	}

	public double getEndX() {
		return endX;
	}

	public void setEndX(double endX) {
		this.endX = endX;
	}

	public double getEndY() {
		return endY;
	}

	public void setEndY(double endY) {
		this.endY = endY;
	}

	public void setStartCoordinate(Coordinate coor) {
		this.startX = coor.getX();
		this.startY = coor.getY();
	}

	public void setEndCoordinate(Coordinate coor) {
		this.endX = coor.getX();
		this.endY = coor.getY();
	}

	public Coordinate getStartCoordinate() {
		return new Coordinate(this.startX, this.startY);
	}

	public Coordinate getEndCoordinate() {
		return new Coordinate(this.endX, this.endY);
	}
	
	public String toString() {
		return "\nstart::\n"
				+ "\tx::\t" + this.startX
				+ "\n\ty::\t" + this.startY
				+ "\nend::\n"
				+ "\tx::\t" + this.endX
				+ "\n\ty::\t" + this.endY
				;
				
	}
}

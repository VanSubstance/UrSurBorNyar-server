package com.my.ursurbornyar.vo;

public class Track {
	private int id;
	private int distance;
	private int time;
	private int point_set_id;
	
	public Track(int id, int distance, int time, int point_set_id) {
		this.id = id;
		this.distance = distance;
		this.time = time;
		this.point_set_id = point_set_id;
	}
	
	@Override
	public String toString() {
		return "Track [id=" + id + ", distance=" + distance + ", time=" + time + ", point_set_id=" + point_set_id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPoint_set_id() {
		return point_set_id;
	}

	public void setPoint_set_id(int point_set_id) {
		this.point_set_id = point_set_id;
	}
	
}

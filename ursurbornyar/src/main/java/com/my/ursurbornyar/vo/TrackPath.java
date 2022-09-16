package com.my.ursurbornyar.vo;

public class TrackPath {
	private int id;
	private int sn;
	private int track_id;
	private String path_id;
	
	@Override
	public String toString() {
		return "TrackPath [id=" + id + ", sn=" + sn + ", track_id=" + track_id + ", path_id=" + path_id + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public int getTrack_id() {
		return track_id;
	}
	public void setTrack_id(int track_id) {
		this.track_id = track_id;
	}
	public String getPath_id() {
		return path_id;
	}
	public void setPath_id(String path_id) {
		this.path_id = path_id;
	}	
}

package com.my.ursurbornyar.vo;

public class TrackPath {
	private String id;
	private int sn;
	private String track_id;
	private String path_id;
	
	@Override
	public String toString() {
		return "TrackPath [id=" + id + ", sn=" + sn + ", track_id=" + track_id + ", path_id=" + path_id + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getTrack_id() {
		return track_id;
	}
	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}
	public String getPath_id() {
		return path_id;
	}
	public void setPath_id(String path_id) {
		this.path_id = path_id;
	}	
}

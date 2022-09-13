package com.my.ursurbornyar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Track;
import com.my.ursurbornyar.vo.Path;

public interface BasicService {
	
	public ArrayList<Place> insertPlace(ArrayList<Place> placeList);
	public String insertPointSet(Place start, Place end);
	public String insertTrack(int time, int distance, String point_set_id);
	public String insertPath(HashMap<String, Object> item, String fid, String tid);
	public String insertTrackPath(int SN, String trackID, String pathID);
	public ArrayList<Place> insertPlaceByPath (HashMap<String, Object> path);
	public int countPlace();
	public int countPointSet();
	
	public int check();
}

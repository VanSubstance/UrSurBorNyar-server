package com.my.ursurbornyar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.PointSet;
import com.my.ursurbornyar.vo.Track;
import com.my.ursurbornyar.vo.TrackPath;
import com.my.ursurbornyar.vo.Path;

public interface BasicService {
	
	public ArrayList<Place> insertPlace(ArrayList<Place> placeList);
	public PointSet insertPointSet(Place start, Place end);
	public Track insertTrack(int time, int distance, int point_set_id);
	public Path insertPath(HashMap<String, Object> item, String fid, String tid);
	public TrackPath insertTrackPath(int SN, int trackID, String pathID);
	public ArrayList<Place> insertPlaceByPath (HashMap<String, Object> path);
	public int countPlace();
	public int countPointSet();
	
	public int check();
}

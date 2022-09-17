package com.my.ursurbornyar.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ursurbornyar.mapper.BasicMapper;
import com.my.ursurbornyar.mapper.PathMapper;
import com.my.ursurbornyar.mapper.PlaceMapper;
import com.my.ursurbornyar.mapper.PointSetMapper;
import com.my.ursurbornyar.mapper.TrackMapper;
import com.my.ursurbornyar.mapper.TrackPathMapper;
import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.service.UtilService;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.PointSet;
import com.my.ursurbornyar.vo.Track;
import com.my.ursurbornyar.vo.TrackPath;
import com.my.ursurbornyar.vo.Coordinate;
import com.my.ursurbornyar.vo.Path;

@Service
public class BasicServiceImpl implements BasicService {
	@Autowired
	private BasicMapper basicMapper;
	@Autowired
	private PlaceMapper placeMapper;
	@Autowired
	private PointSetMapper pointSetMapper;
	@Autowired
	private TrackMapper trackMapper;
	@Autowired
	private PathMapper pathMapper;
	@Autowired
	private TrackPathMapper trackPathMapper;
	@Autowired
	private UtilService utilService;

	@Override
	public ArrayList<Place> insertPlace(ArrayList<Place> placeList) {
		
		System.out.println("start insert placeList");
		//System.out.println(placeList);
		
		for (Place place : placeList) {
			// set place id
			int pNum = countPlace();
			place.setId(utilService.convertHex(pNum));
			
			if (utilService.checkDuplicatedPlace(place) > 0) {
				// set duplicated id
				String placeID = placeMapper.getPlaceID(place);
				place.setId(placeID);
				//System.out.println("Already stored place : " + place);
			}
			else {
				placeMapper.insertPlace(place);
			}
		}
		System.out.println("end insert placeList");
		
		//System.out.println(placeList);
		return placeList;
	}
	
	@Override
	public PointSet insertPointSet(Place start, Place end) {
		
		System.out.println("start insert point set");
		
		String startID = placeMapper.getPlaceID(start);
		String endID = placeMapper.getPlaceID(end);
		
		PointSet pointSet = new PointSet(0,startID, endID);
		//System.out.println("Point Set : " + pointSet);
		
		if(pointSetMapper.checkDuplicatedPointSet(pointSet) == 0) {
			int res = pointSetMapper.insertPointSet(pointSet);
			int pointSetID = pointSetMapper.getPointSetID(pointSet);
			pointSet.setId(pointSetID);
			//System.out.println("Inserted PointSet : " + pointSet);
		}
		else {
			System.out.println("Already inserted Point Set");
			int pointSetID = pointSetMapper.getPointSetID(pointSet);
			pointSet.setId(pointSetID);
		}
		return pointSet;
	}
	
	@Override
	public Track insertTrack(int time, int distance, int point_set_id) {
		
		Track track = new Track(0, time, distance, point_set_id);
		//System.out.println("track");
		//System.out.println(track);
		if (trackMapper.checkDuplicatedTrack(track) == 0) {
			int res = trackMapper.insertTrack(track);
		}
		int trackID = trackMapper.getTrackID(track);
		track.setId(trackID);
		
		return track;
	}
	@Override
	public Path insertPath(HashMap<String, Object> item, String fid, String tid) {
		
		Path path = new Path();
		int pNum = pathMapper.countPath();
		String pNum16 = utilService.convertHex(pNum);
		
		path.setId(pNum16);
		path.setName((String) item.get("routeNm"));
		path.setStart_place_id(fid);
		path.setEnd_place_id(tid);
		
		//System.out.println("path : " + path);
		if (pathMapper.checkDuplicatedPath(path) == 0) {
			//System.out.println("insert path");
			pathMapper.insertPath(path);
		}
		else {
			String pathID = pathMapper.getPathID(path);
			path.setId(pathID);
		}
		
		return path;
	}

	public TrackPath insertTrackPath(int SN, int trackID, String pathID) {
		
		TrackPath trackPath = new TrackPath();
		trackPath.setSn(SN);
		trackPath.setTrack_id(trackID);
		trackPath.setPath_id(pathID);
		
		//System.out.println("trackPath : " + trackPath);
		if(trackPathMapper.checkDuplicatedTrackPath(trackPath) == 0) {
			//System.out.println("insert trackPath");
			trackPathMapper.insertTrackPath(trackPath);
			int trackPathID = trackPathMapper.getTrackPathID(trackPath);
			trackPath.setId(trackPathID);
		}
		
		return trackPath;
	}
	
	public ArrayList<Place> insertPlaceByPath (HashMap<String, Object> path){
		
		ArrayList<Place> pl = new ArrayList<Place>();
		
		// create fplace, tplace and set value
		Place fp = new Place();
		Place tp = new Place();
		
		Coordinate fcoor = new Coordinate(Double.parseDouble(path.get("fx").toString()),Double.parseDouble(path.get("fy").toString()));
		Coordinate tcoor = new Coordinate(Double.parseDouble(path.get("tx").toString()),Double.parseDouble(path.get("ty").toString()));
		
		fp.setName((String) path.get("fname"));
		fp.setCoordinate(fcoor);
		
		tp.setName((String) path.get("tname"));
		tp.setCoordinate(tcoor);
		
		pl.add(fp);
		pl.add(tp);
		
		ArrayList<Place> resPlaceList = insertPlace(pl);
		
		return resPlaceList; 
	}
	
	@Override
	public int countPlace() {
		return placeMapper.countPlace();
	}
	
	@Override
	public int countPointSet() {
		return pointSetMapper.countPointSet();
	}
	
	@Override
	public int check() {
		// TODO Need to Re-check
		return basicMapper.check();
	}
}

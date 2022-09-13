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
		
		int pNum = countPlace();
		int res = 0;
		System.out.println(pNum);
		
		for(Place place : placeList) {
			place.setId(utilService.convertHex(pNum));
			pNum += 1;
		}
		
		System.out.println("start insert placeList");
		System.out.println(placeList);
		
		for (Place place : placeList) {
			if (utilService.checkDuplicatedPlace(place) > 0) {
				System.out.println("Already stored place.");
			}
			else {
				res += placeMapper.insertPlace(place);
			}
		}
		System.out.println("end insert placeList");
		
		return placeList;
	}
	
	@Override
	public String insertPointSet(Place start, Place end) {
		
		int pNum = countPointSet();
		String pNum16 = utilService.convertHex(pNum);
		String startID = placeMapper.getPlaceID(start);
		String endID = placeMapper.getPlaceID(end);
		
		PointSet pointSet = new PointSet(pNum16,startID, endID);
		if(pointSetMapper.checkDuplicatedPointSet(pointSet) == 0) {
			int res = pointSetMapper.insertPointSet(pointSet);
			System.out.println("Inserted PointSet : " + res);
			
			return pNum16;
		}
		else {
			System.out.println("Already inserted Point Set");
			return null;	
		}
	}
	
	@Override
	public String insertTrack(int time, int distance, String point_set_id) {
		
		int pNum = trackMapper.countTrack();
		String pNum16 = utilService.convertHex(pNum);
		
		Track track = new Track(pNum16, time, distance, point_set_id);
		System.out.println("track");
		System.out.println(track);
		int res = trackMapper.insertTrack(track);
		
		if (res == 1) {
			return pNum16;
		}
		else {
			return null;
		}
	}
	@Override
	public String insertPath(HashMap<String, Object> item, String fid, String tid) {
		
		Path path = new Path();
		int pNum = pathMapper.countPath();
		String pNum16 = utilService.convertHex(pNum);
		
		path.setId(pNum16);
		path.setName((String) item.get("routeNm"));
		path.setStartId(fid);
		path.setEndId(tid);
		
		if (pathMapper.checkDuplicatedPlace(path) == 0) {
			pathMapper.insertPath(path);
		}
		
		return pNum16;
	}

	public String insertTrackPath(int SN, String trackID, String pathID) {
		
		int pNum = trackPathMapper.countTrackPath();
		String pNum16 = utilService.convertHex(pNum);
		
		TrackPath trackPath = new TrackPath();
		trackPath.setId(pNum16);
		trackPath.setSn(SN);
		trackPath.setTrack_id(trackID);
		trackPath.setPath_id(pathID);
		
		if(trackPathMapper.checkDuplicatedTrackPath(trackPath) == 0) {
			trackPathMapper.insertTrackPath(trackPath);
		}
		
		return pNum16;
	}
	
	public ArrayList<Place> insertPlaceByPath (HashMap<String, Object> path){
		
		ArrayList<Place> pl = new ArrayList<Place>();
		
		// create fplace, tplace and set value
		Place fp = new Place();
		Place tp = new Place();
		
		Coordinate fcoor = new Coordinate((double) path.get("fx"),(double) path.get("fy"));
		Coordinate tcoor = new Coordinate((double) path.get("tx"),(double) path.get("ty"));
		
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

package com.my.ursurbornyar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.service.externalapi.TransportService;
import com.my.ursurbornyar.vo.Coordinate;
import com.my.ursurbornyar.vo.Path;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.PointSet;
import com.my.ursurbornyar.vo.Track;
import com.my.ursurbornyar.vo.TrackPath;
import com.my.ursurbornyar.vo.TransportRequest;

@RestController
@RequestMapping(value = "/trans")
public class TransportController {

	@Autowired
	private BasicService basicService;
	@Autowired
	private TransportService tranService;

	@RequestMapping(value = "/bus", method = RequestMethod.PATCH)
	public ResponseEntity<?> onlyBus(@RequestBody HashMap<String, Place> body) {
		// System.out.println(body);
		LinkedHashMap<String, Object> responseHashMap = new LinkedHashMap<String, Object>();
		
		// get start, end place data
		Place startPlace = body.get("startPlace");
		Place endPlace = body.get("endPlace");
		Coordinate startCoor = startPlace.getCoordinate();
		Coordinate endCoor = endPlace.getCoordinate();
		
		// insert start, end place
		ArrayList<Place> startEndPlaceList = new ArrayList<Place>();
		startEndPlaceList.add(startPlace);
		startEndPlaceList.add(endPlace);
		ArrayList<Place> insertRes = basicService.insertPlace(startEndPlaceList);
		
		// insert startPlace, endPlace in reponseHashMap
		responseHashMap.put("startPlace", startPlace);
		responseHashMap.put("endPlace", endPlace);
		
		// insert point_set_tb
		PointSet pointSet = basicService.insertPointSet(startPlace, endPlace);
		// System.out.println("Insert PointSet : " + pointSet);
		// get track data from external API
		ResponseEntity<?> responseEntity = tranService.getPathInfoByBusList(new TransportRequest(startCoor, endCoor));
		
		System.out.println("getBody");
		//System.out.println(responseEntity.getBody());
		
		// parse data by using bidirectional casting between LinkedHashMap and ArrayList
		LinkedHashMap<String, Object> obj = (LinkedHashMap<String, Object>) responseEntity.getBody();
		ArrayList<Object> itemList = (ArrayList<Object>) obj.get("itemList");
		
		System.out.println("itemList");
		// System.out.println(itemList);
		// insert route in reponseHashMap
		responseHashMap.put("route", itemList.get(0));
		
		// insert track
		for (Object item : itemList) {
			
			// System.out.println(item);
			
			LinkedHashMap<String, Object> ob1 = (LinkedHashMap<String, Object>) item;
			ArrayList<Object> path = (ArrayList<Object>) ob1.get("pathList");
			int time = Integer.parseInt((String) ob1.get("time"));
			int distance = Integer.parseInt((String) ob1.get("distance"));
			
			Track track = basicService.insertTrack(time, distance, pointSet.getId());
			System.out.println("time : " + time + " distance : " + distance);
			
			
			// SN for trackpath
			int SN = 0;
			for (Object p : path) {
				
				HashMap<String, Object> pathMap = (HashMap<String, Object>) p;
				
				//System.out.println("Individual path");
				//System.out.println(p);
				
				ArrayList<Place> insertedPl = basicService.insertPlaceByPath(pathMap);
				
				String fid = insertedPl.get(0).getId();
				String tid = insertedPl.get(1).getId();
				//System.out.println("fid : " + fid + " tid : " +tid);
				Path returnPath = basicService.insertPath(pathMap, fid, tid);
				TrackPath trackPath = basicService.insertTrackPath(SN, track.getId(), returnPath.getId());
				SN++;
				//System.out.println(trackPath);
			}
			
			//System.out.println(ob1.get("pathList"));
		}
		
		ResponseEntity<?> successMessage = new ResponseEntity<>(responseHashMap, HttpStatus.OK);
		return successMessage;
	}

	@RequestMapping(value = "/sub", method = RequestMethod.PATCH)
	public ResponseEntity<?> onlySubway(@RequestBody HashMap<String, Object> body) {
		System.out.println(body);

		Place startPlace = new Place((HashMap<String, Object>) body.get("startPlace"));
		Place endPlace = new Place((HashMap<String, Object>) body.get("endPlace"));
		Coordinate startCoor = startPlace.getCoordinate();
		Coordinate endCoor = endPlace.getCoordinate();

		return tranService.getPathInfoBySubwayList(new TransportRequest(startCoor, endCoor));
	}

	@RequestMapping(value = "/busNsub", method = RequestMethod.PATCH)
	public ResponseEntity<?> busAndSubway(@RequestBody HashMap<String, Object> body) {
		System.out.println(body);

		Place startPlace = new Place((HashMap<String, Object>) body.get("startPlace"));
		Place endPlace = new Place((HashMap<String, Object>) body.get("endPlace"));
		Coordinate startCoor = startPlace.getCoordinate();
		Coordinate endCoor = endPlace.getCoordinate();

		return tranService.getPathInfoByBusNSubList(new TransportRequest(startCoor, endCoor));
	}

}

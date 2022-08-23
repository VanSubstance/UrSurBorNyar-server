package com.my.ursurbornyar.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.ursurbornyar.service.externalapi.TransportService;
import com.my.ursurbornyar.vo.Coordinate;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.TransportRequest;

@RestController
@RequestMapping(value = "/trans")
public class TransportController {

	@Autowired
	private TransportService tranService;

	@RequestMapping(value = "/bus", method = RequestMethod.PATCH)
	public ResponseEntity<?> onlyBus(@RequestBody HashMap<String, Object> body) {
		System.out.println(body);
		
		Place startPlace = new Place((HashMap<String, Object>) body.get("startPlace"));
		Place endPlace = new Place((HashMap<String, Object>) body.get("endPlace"));
		
		Coordinate startCoor = startPlace.getCoordinate();
		Coordinate endCoor = endPlace.getCoordinate();

		return tranService.getPathInfoByBusList(new TransportRequest(startCoor, endCoor));
	}

	@RequestMapping(value = "/sub", method = RequestMethod.PATCH)
	public ResponseEntity<?> onlySubway(@RequestBody HashMap<String, Object> body) {
		System.out.println(body);
		Coordinate startCoor = ((Place) body.get("startPlace")).getCoordinate();
		Coordinate endCoor = ((Place) body.get("endPlace")).getCoordinate();

		return tranService.getPathInfoBySubwayList(new TransportRequest(startCoor, endCoor));
	}

	@RequestMapping(value = "/busNsub", method = RequestMethod.PATCH)
	public ResponseEntity<?> busAndSubway(@RequestBody HashMap<String, Object> body) {
		System.out.println(body);
		Coordinate startCoor = ((Place) body.get("startPlace")).getCoordinate();
		Coordinate endCoor = ((Place) body.get("endPlace")).getCoordinate();

		return tranService.getPathInfoByBusNSubList(new TransportRequest(startCoor, endCoor));
	}

}

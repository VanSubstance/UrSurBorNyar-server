package com.my.ursurbornyar.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.service.UtilService;
import com.my.ursurbornyar.vo.Path;
import com.my.ursurbornyar.vo.Place;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

	@Autowired
	private BasicService basicService;
	@Autowired
	private UtilService utilService;

	@RequestMapping(value = "/twocoors", method = RequestMethod.POST)
	public ResponseEntity<?> getTwoCoors(@RequestBody HashMap<String, ArrayList<Place>> req) {
		System.out.println("바디:: " + req);
		if (req != null) {
			try {				
				ArrayList<Place> placeList = req.get("placeList");
				System.out.println(placeList.get(0).getCoordinate());
				
				ResponseEntity<?> responseEntity = new ResponseEntity(placeList, HttpStatus.OK);
								
				ArrayList<Place> insertRes = basicService.insertPlace(placeList);
				
				return responseEntity;
			} catch (ClassCastException e) {
				System.out.println(e);
				ResponseEntity<?> responseEntity  = new ResponseEntity("Invalid parameters.", HttpStatus.EXPECTATION_FAILED);
				
				return responseEntity;
			}
		} else {
			ResponseEntity<?> responseEntity = new ResponseEntity("Invalid parameters.", HttpStatus.EXPECTATION_FAILED);
			
			return responseEntity;
		}
	}

	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public int check() {
		return basicService.check();
	}
}

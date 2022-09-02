package com.my.ursurbornyar.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.my.ursurbornyar.vo.Response;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

	@Autowired
	private BasicService basicService;
	@Autowired
	private UtilService utilService;

	@RequestMapping(value = "/twocoors", method = RequestMethod.POST)
	public Response getTwoCoors(@RequestBody HashMap<String, ArrayList<Place>> req) {
		System.out.println("바디:: " + req);
		if (req != null) {
			try {				
				ArrayList<Place> placeList = req.get("placeList");
				System.out.println(placeList.get(0).getCoordinate());
				
				Response res = new Response();
								
				int insertRes = basicService.insertPlace(placeList);
				
				res.setData(placeList);
				res.setMessage("Inserted place count : " + insertRes);
				
				return res;
			} catch (ClassCastException e) {
				System.out.println(e);
				Response res = new Response(false);
				res.setMessage("Invalid parameters.");
				return res;
			}
		} else {
			Response res = new Response(false);
			res.setMessage("Invalid parameters.");
			return res;
		}
	}

	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public int check() {
		return basicService.check();
	}
}

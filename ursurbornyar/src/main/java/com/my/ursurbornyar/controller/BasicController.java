package com.my.ursurbornyar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.vo.Path;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Response;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

	@Autowired
	private BasicService basicService;

	@RequestMapping(value = "/twocoors", method = RequestMethod.POST)
	public Response getTwoCoors(@RequestBody HashMap<String, Object> req) {
		System.out.println("바디:: " + req);
		if (req != null) {
			try {
				ArrayList<Place> placeList = (ArrayList<Place>) req.get("placeList");
				Response res = new Response();
				System.out.println(placeList);
				res.setData(placeList);
				return res;
			} catch (ClassCastException e) {
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

	@RequestMapping(value = "/writer/{name}", method = RequestMethod.GET)
	public List<Path> searchByName(@PathVariable String name) {
		return basicService.searchByName(name);
	}

	@RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
	public List<Path> searchById(@PathVariable String id) {
		return basicService.searchById(id);
	}

}

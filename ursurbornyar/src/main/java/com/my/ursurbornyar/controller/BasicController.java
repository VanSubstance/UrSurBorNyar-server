package com.my.ursurbornyar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.vo.Basic;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {
	
	@Autowired
	private BasicService basicService;
	
	@RequestMapping(value="/dbtest", method = RequestMethod.GET)
	public String check() {
		return "HI";
	}
	
	@RequestMapping(value="/writer/{name}", method = RequestMethod.GET)
	public List<Basic> searchByName(@PathVariable String name){
		return basicService.searchByName(name);
	}
	
	@RequestMapping(value="/genre/{id}", method = RequestMethod.GET)
	public List<Basic> searchById(@PathVariable String id){
		return basicService.searchById(id);
	}

}
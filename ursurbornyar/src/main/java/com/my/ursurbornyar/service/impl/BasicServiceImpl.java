package com.my.ursurbornyar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ursurbornyar.mapper.BasicMapper;
import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.service.UtilService;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

@Service
public class BasicServiceImpl implements BasicService {
	@Autowired
	private BasicMapper mapper;
	
	@Autowired
	private UtilService utilService;

	@Override
	public int insertPlace(ArrayList<Place> placeList) {
		
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
				res += mapper.insertPlace(place);
			}
		}
		System.out.println("end insert placeList");
		
		return res;
	}
		
	@Override
	public int countPlace() {
		return mapper.countPlace();
	}
	
	@Override
	public int check() {
		// TODO Need to Re-check
		return mapper.check();
	}
	@Override
	public void insertUser(Path item) {
		// TODO Auto-generated method stub
		mapper.insertUser(item);
	}

	@Override
	public List<Path> selectBook(String title) {
		// TODO Auto-generated method stub
		return mapper.selectBook(title);
	}
	
	@Override
	public List<Path> searchByName(String name){
		
		return mapper.searchByName(name);	
	}
	
	@Override
	public List<Path> searchById(String id){
		
		return mapper.searchById(id);	
	}
	
}

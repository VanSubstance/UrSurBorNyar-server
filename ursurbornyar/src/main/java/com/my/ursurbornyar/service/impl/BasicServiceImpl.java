package com.my.ursurbornyar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ursurbornyar.mapper.BasicMapper;
import com.my.ursurbornyar.mapper.PlaceMapper;
import com.my.ursurbornyar.mapper.PointSetMapper;
import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.service.UtilService;

import com.my.ursurbornyar.vo.Place;
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
				res += placeMapper.insertPlace(place);
			}
		}
		System.out.println("end insert placeList");
		
		return res;
	}
	
	@Override
	public int insertPointSet(Path path) {
		
		int pNum = countPointSet();
		String pNum16 = utilService.convertHex(pNum);
		int res = pointSetMapper.insertPointSet(path);
		
		return 1;
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

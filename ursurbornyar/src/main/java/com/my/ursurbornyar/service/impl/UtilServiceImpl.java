package com.my.ursurbornyar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ursurbornyar.service.UtilService;
import com.my.ursurbornyar.vo.Place;

@Service
public class UtilServiceImpl implements UtilService {

	public String convertHex (int num) {
		String pNum16 = Integer.toHexString(num);
		String pNum162 = String.format("%11s", pNum16);
		return pNum162;
	}
	
	public Boolean checkDuplicatedPlace (Place place) {
		
		return true;
	}
	
}

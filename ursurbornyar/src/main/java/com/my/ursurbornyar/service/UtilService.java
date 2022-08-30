package com.my.ursurbornyar.service;

import java.util.List;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface UtilService {
	
	public String convertHex(int num);
	public int checkDuplicatedPlace(Place place);
}

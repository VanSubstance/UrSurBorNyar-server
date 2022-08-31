package com.my.ursurbornyar.service;

import java.util.ArrayList;
import java.util.List;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface BasicService {
	
	public int insertPlace(ArrayList<Place> placeList);
	public int insertPointSet(Path path);
	public int countPlace();
	public int countPointSet();
	
	public int check();
}

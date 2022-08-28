package com.my.ursurbornyar.service;

import java.util.ArrayList;
import java.util.List;

import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface BasicService {
	
	public int insertPlace(ArrayList<Place> placeList);
	public int countPlace();
	
	public int check();
	
	public void insertUser(Path item);
	public List<Path> selectBook(String title);
	
	public List<Path> searchByName(String name);
	
	public List<Path> searchById(String id);
}

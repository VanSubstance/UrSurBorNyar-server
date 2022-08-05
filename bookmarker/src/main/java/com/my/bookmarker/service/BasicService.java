package com.my.bookmarker.service;

import java.util.List;

import com.my.bookmarker.vo.Basic;

public interface BasicService {
	
	public void insertUser(Basic item);
	public List<Basic> selectBook(String title);
	
	public List<Basic> searchByName(String name);
	
	public List<Basic> searchById(String id);
}

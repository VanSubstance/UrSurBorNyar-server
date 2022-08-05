package com.my.bookmarker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bookmarker.mapper.BasicMapper;
import com.my.bookmarker.service.BasicService;
import com.my.bookmarker.vo.Basic;

@Service
public class BasicServiceImpl implements BasicService {
	@Autowired
	private BasicMapper mapper;

	@Override
	public void insertUser(Basic item) {
		// TODO Auto-generated method stub
		mapper.insertUser(item);
	}

	@Override
	public List<Basic> selectBook(String title) {
		// TODO Auto-generated method stub
		return mapper.selectBook(title);
	}
	
	@Override
	public List<Basic> searchByName(String name){
		
		return mapper.searchByName(name);	
	}
	
	@Override
	public List<Basic> searchById(String id){
		
		return mapper.searchById(id);	
	}
	
}

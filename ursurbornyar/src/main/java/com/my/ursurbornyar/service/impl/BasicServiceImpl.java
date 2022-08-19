package com.my.ursurbornyar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ursurbornyar.mapper.BasicMapper;
import com.my.ursurbornyar.service.BasicService;
import com.my.ursurbornyar.vo.Path;

@Service
public class BasicServiceImpl implements BasicService {
	@Autowired
	private BasicMapper mapper;

	
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

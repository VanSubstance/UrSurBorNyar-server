package com.my.bookmarker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.bookmarker.vo.Basic;

public interface BasicMapper {

	public void insertUser(@Param("user") Basic user);
	public List<Basic> selectBook(@Param("title") String title);
	
	public List<Basic> searchByName(@Param("name") String name);
	
	public List<Basic> searchById(@Param("id") String id);
}

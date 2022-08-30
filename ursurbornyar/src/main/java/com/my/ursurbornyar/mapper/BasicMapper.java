package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface BasicMapper {

	public int insertPlace(@Param("place") Place place);
	public int countPlace();
	public int checkDuplicatedPlace(@Param("place") Place place);
	public int check();
	
	public void insertUser(@Param("user") Path user);
	public List<Path> selectBook(@Param("title") String title);
	
	public List<Path> searchByName(@Param("name") String name);
	
	public List<Path> searchById(@Param("id") String id);
}

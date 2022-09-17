package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface PathMapper {

	public int insertPath(@Param("path") Path path);
	public int countPath();
	public int checkDuplicatedPath(@Param("path") Path path);
	public String getPathID(@Param("path") Path path);

}
package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.TrackPath;
import com.my.ursurbornyar.vo.Path;

public interface TrackPathMapper {

	public int insertTrackPath(@Param("trackpath") TrackPath trackPath);
	public int countTrackPath();
	public int checkDuplicatedTrackPath(@Param("trackpath") TrackPath trackPath);
	public int getTrackPathID(@Param("trackpath") TrackPath trackPath);
}

package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Track;
import com.my.ursurbornyar.vo.Path;

public interface TrackMapper {

	public int countTrack();
	public int insertTrack(@Param("track") Track track);
	public int checkDuplicatedTrack(@Param("track") Track track);
	public int getTrackID(@Param("track") Track track);
} 

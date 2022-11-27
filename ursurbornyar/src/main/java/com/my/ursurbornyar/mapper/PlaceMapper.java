package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.Path;

public interface PlaceMapper {

	public int insertPlace(@Param("place") Place place);
	public int countPlace();
	public String getPlaceID(@Param("place") Place place);
	public int checkDuplicatedPlace(@Param("place") Place place);

}

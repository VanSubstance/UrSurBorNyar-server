package com.my.ursurbornyar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.my.ursurbornyar.vo.Place;
import com.my.ursurbornyar.vo.PointSet;
import com.my.ursurbornyar.vo.Path;

public interface PointSetMapper {

	public int insertPointSet(@Param("pointset") PointSet pointset);
	public int checkDuplicatedPointSet (@Param("pointset") PointSet pointset);
	public String getPointSetID(@Param("pointset") PointSet pointset);
	public int countPointSet();

}

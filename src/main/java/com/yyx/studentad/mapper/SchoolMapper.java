package com.yyx.studentad.mapper;

import com.yyx.studentad.pojo.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolMapper {
    int deleteByPrimaryKey(Integer schoolId);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer schoolId);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}
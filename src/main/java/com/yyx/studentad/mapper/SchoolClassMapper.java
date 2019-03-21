package com.yyx.studentad.mapper;

import com.yyx.studentad.pojo.SchoolClass;

public interface SchoolClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(SchoolClass record);

    int insertSelective(SchoolClass record);

    SchoolClass selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(SchoolClass record);

    int updateByPrimaryKey(SchoolClass record);
}
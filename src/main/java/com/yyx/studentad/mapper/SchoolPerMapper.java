package com.yyx.studentad.mapper;

import com.yyx.studentad.pojo.SchoolPer;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolPerMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(SchoolPer record);

    int insertSelective(SchoolPer record);

    SchoolPer selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(SchoolPer record);

    int updateByPrimaryKey(SchoolPer record);

    SchoolPer selectByUsernameAndPassword (SchoolPer record);

    int selectByUsername(String username);

    int updatePasswordByPerUsername(SchoolPer per);
}
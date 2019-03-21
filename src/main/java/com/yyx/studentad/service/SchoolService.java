package com.yyx.studentad.service;

import com.yyx.studentad.pojo.School;
import com.yyx.studentad.resultbean.ResultBean;

/**
 * 阿桑
 * 2019/3/18
 */
public interface SchoolService {
    /**
     * 添加学校
     * @param school 学校
     * @return
     */
    ResultBean addSchool(School school);
}

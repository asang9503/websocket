package com.yyx.studentad.service.impl;

import com.yyx.studentad.Util.ResultUtil;
import com.yyx.studentad.mapper.SchoolMapper;
import com.yyx.studentad.pojo.School;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 阿桑
 * 2019/3/18
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private ResultBean resultBean;

    @Autowired
    private ResultUtil resultUtil;

    @Override
    public ResultBean addSchool(School school) {
        if (null == school) {
            resultBean = resultUtil.ErrorReturn("不能为空");
        } else {
            resultBean = schoolMapper.insertSelective(school) > 0 ? resultUtil.RightReturn("添加成功") : resultUtil.ErrorReturn("添加失败");
        }
        return resultBean;
    }
}

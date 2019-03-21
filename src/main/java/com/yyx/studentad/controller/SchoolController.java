package com.yyx.studentad.controller;

import com.yyx.studentad.pojo.School;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 阿桑
 * 2019/3/18
 */
@RestController
@RequestMapping("/do/school/")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("addSchool")
    public ResultBean addSchool(@Valid School school) {
        return schoolService.addSchool(school);
    }
}

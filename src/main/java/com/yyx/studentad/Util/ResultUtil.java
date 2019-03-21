package com.yyx.studentad.Util;

import com.yyx.studentad.constant.ConstantForAllPage;
import com.yyx.studentad.resultbean.ResultBean;
import org.springframework.stereotype.Component;

/**
 * 阿桑
 * 2019/3/13
 */
@Component
public class ResultUtil {


    public ResultBean RightReturn(String msg) {
        return new ResultBean(msg, ConstantForAllPage.SUCCESS,null);
    }
    public ResultBean ErrorReturn(String msg) {
        return new ResultBean(msg,ConstantForAllPage.ERROR,null);
    }
}

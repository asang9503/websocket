package com.yyx.studentad.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yyx.studentad.Util.JedisUtil;
import com.yyx.studentad.constant.ConstantForAllPage;
import com.yyx.studentad.mapper.SchoolPerMapper;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.Util.ResultUtil;
import com.yyx.studentad.service.SchoolPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 阿桑
 * 2019/3/12
 */
@Service
public class SchoolPerServiceImpl implements SchoolPerService {

    @Autowired
    private SchoolPerMapper perMapper;
    @Autowired
    private ResultUtil resultUtil;
    @Autowired
    private ResultBean resultBean;
    @Autowired
    private Map<String, Object> map;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ResultBean registerIsSuccess(SchoolPer per) {
        if (per == null) {
            resultBean = resultUtil.ErrorReturn("输入不能为空");
        } else {
            resultBean = perMapper.insertSelective(per) > 0 ? resultUtil.RightReturn("注册成功") :
            resultUtil.ErrorReturn("注册失败");
        }
        return resultBean;
    }

    @Override
    public ResultBean perUsernameExists(String perUsername) {
        if (perUsername != null && "" != perUsername) {
            int perID = perMapper.selectByUsername(perUsername);
            resultBean = perID > 0 ? resultUtil.ErrorReturn("该账号已存在！") :
                    resultUtil.ErrorReturn("该账号可以使用！");
        } else {
            resultBean = resultUtil.ErrorReturn("输入不能为空！");
        }
        return resultBean;
    }

    @Override
    public ResultBean login(SchoolPer per) {

        if (per == null) {
            resultBean = resultUtil.ErrorReturn("账号或者密码错误！");
        } else {
            per = perMapper.selectByUsernameAndPassword(per);
            if (null != per) {
                String key = ConstantForAllPage.TOKEN + per.getPerUsername();
                String value1 = JSONObject.toJSONString(per);
                jedisUtil.saveStringValue(key, value1);
                resultBean = new ResultBean("登陆成功！", ConstantForAllPage.SUCCESS, key);
            } else {
                resultBean = resultUtil.ErrorReturn("登录失败！");
            }
        }
        return resultBean;
    }

    @Override
    public ResultBean isLogin(String token) {
        if (null != token && "" != token) {
            String value = jedisUtil.getStringValue(token);
            resultBean = (null == value || "" == value) ? resultUtil.ErrorReturn("请登录") :
                    resultUtil.RightReturn("已登录");
        } else {
            resultBean =  resultUtil.ErrorReturn("请登录");
        }
        return resultBean;
    }

    @Override
    public ResultBean exitLogin(String token) {
        if (null != token && "" != token) {
            resultBean = jedisUtil.removeString(token) ? resultUtil.RightReturn("登出成功") : resultUtil.ErrorReturn("登出失败!稍后再试!");
        } else {
            resultBean = resultUtil.ErrorReturn("登出失败!稍后再试!");
        }
        return resultBean;
    }

    @Override
    public ResultBean updatePassword(SchoolPer per) {
        if (null == per) {
            resultBean = resultUtil.ErrorReturn("输入不能为空！");
        } else {
            resultBean = perMapper.updatePasswordByPerUsername(per) > 0 ? resultUtil.RightReturn("修改成功") :
                    resultUtil.ErrorReturn("修改失败！");
        }
        return resultBean;
    }
}

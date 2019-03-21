package com.yyx.studentad.service;


import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.pojo.SchoolPer;

/**
 * 阿桑
 * 2019/3/12
 */

public interface SchoolPerService {
    /**
     * 注册账号
     * @param per 账号 密码
     * @return
     */
    ResultBean registerIsSuccess(SchoolPer per);

    /**
     * 判断账号是否存在
     * @param perUsername 账号
     * @return
     */
    ResultBean perUsernameExists(String perUsername);

    /**
     * 登录
     * @param per 账号密码
     * @return
     */
    ResultBean login(SchoolPer per);

    /**
     * 判断是否登录
     * @param token 令牌
     * @return
     */
    ResultBean isLogin(String token);

    /**
     * 退出登录
     * @param token 令牌
     * @return
     */
    ResultBean exitLogin(String token);

    /**
     * 修改密码
     * @param per 账号 密码
     * @return
     */
    ResultBean updatePassword(SchoolPer per);
}

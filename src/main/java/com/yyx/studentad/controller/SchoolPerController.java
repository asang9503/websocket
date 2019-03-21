package com.yyx.studentad.controller;

import com.yyx.studentad.pojo.SchoolPer;
import com.yyx.studentad.resultbean.ResultBean;
import com.yyx.studentad.service.SchoolPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 阿桑
 * 2019/3/12
 */
@RestController
@RequestMapping("/do/user")
public class SchoolPerController {

    @Autowired
    private SchoolPerService perService;

    /**
     * 注册
     * @param per 账号密码
     * @return
     */
    @PostMapping("/register")
    public ResultBean register(@Valid SchoolPer per) {
        return perService.registerIsSuccess(per);
    }

    /**
     * 检查账号是否重复
     * @param perUsername 账号
     * @return
     */
    @GetMapping("/perUsernameExists")
    public ResultBean perUsernameExists(@RequestParam(name = "perUsername") String perUsername) {
        return perService.perUsernameExists(perUsername);
    }

    /**
     * 登录
     * @param per 账号 密码
     * @return
     */
    @PostMapping("/login")
    public ResultBean login(@Valid SchoolPer per) {
        return perService.login(per);
    }

    /**
     * 判断是否登录
     * @param token 令牌
     * @return
     */
    @PostMapping("/isLogin")
    public ResultBean isLogin(@RequestParam(name = "token")String token) {
        return perService.isLogin(token);
    }

    /**
     * 退出登录
     * @param token 令牌
     * @return
     */
    @PostMapping("/exitLogin")
    public ResultBean exitLogin(@RequestParam(name = "token")String token) {
        return perService.exitLogin(token);
    }

    /**
     * 更新密码
     * @param per 账号 密码
     * @return
     */
    @PostMapping("/updatePassword")
    public ResultBean updatePassword(@Valid SchoolPer per) {
        return perService.updatePassword(per);
    }
}

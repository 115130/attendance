package com.bylw.attendance.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.bylw.attendance.entity.UserInfo;
import com.bylw.attendance.entity.vo.UserInfoVo;
import com.bylw.attendance.service.IUserInfoService;
import com.bylw.attendance.utils.Response;
import com.bylw.attendance.utils.RoleCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@RestController
@CrossOrigin
@RequestMapping("/attendance/userinfo")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;
    
    @GetMapping("getUserInfo")
    public Response getUserInfo(){
        UserInfoVo userInfo = userInfoService.getUserInfo();
        return Response.ok().data("userinfo",userInfo);
    }

    @PostMapping("modifyUserInfo")
    public Response modifyUserInfo(@RequestBody UserInfoVo userInfoVo){
        userInfoService.updateUserInfo(userInfoVo);
        return Response.ok();
    }

    @PostMapping("modifyOtherUserInfo")
    public Response modifyOtherUserInfo(@RequestBody UserInfoVo userInfoVo){
        userInfoService.updateUserInfoByOther(userInfoVo);
        return Response.ok();
    }

    @GetMapping("getAllOtherUserInfo")
    public Response getAllOtherUserInfo(){
        List<UserInfoVo> userInfoByOther = userInfoService.getUserInfoByOther();
        return Response.ok().data("userInfoList",userInfoByOther);
    }


}

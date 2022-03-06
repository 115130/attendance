package com.bylw.attendance.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.bylw.attendance.entity.vo.LoginVo;
import com.bylw.attendance.service.ILoginService;
import com.bylw.attendance.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {
    @Autowired
    private ILoginService service;

    @PostMapping("login")
    public Response login(@RequestBody LoginVo loginVo){
        service.login(loginVo);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        log.warn(tokenInfo.getTokenValue());
        log.warn(tokenInfo.getTokenName());
        return Response.ok().data("token",tokenInfo.getTokenValue()).data("token_name",tokenInfo.getTokenName());
    }

//    @GetMapping("getCurrentPermissionList")
//    public Response getPermissionList(){
//        StpUtil.checkLogin();
//        List<String> permissionList = StpUtil.getPermissionList();
//        log.error(permissionList.toString());
//        return Response.ok().data("permissionList",permissionList);
//    }

    @GetMapping("info")
    public Response isLogin(){
        List<String> permissionList = StpUtil.getPermissionList();
        log.error("登陆状态:"+StpUtil.isLogin());
        log.error("权限详情:"+permissionList.toString());
        return Response.ok().data("roles",permissionList);
    }

}

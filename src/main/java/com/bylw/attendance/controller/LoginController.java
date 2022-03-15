package com.bylw.attendance.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.bylw.attendance.entity.User;
import com.bylw.attendance.entity.vo.LoginVo;
import com.bylw.attendance.service.ILoginService;
import com.bylw.attendance.service.IUserService;
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

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public Response login(@RequestBody LoginVo loginVo){
        service.login(loginVo);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return Response.ok().data("token",tokenInfo.getTokenValue()).data("token_name",tokenInfo.getTokenName());
    }

    @GetMapping("info")
    public Response isLogin(){
        List<String> permissionList = StpUtil.getPermissionList();
        String id = StpUtil.getLoginIdAsString();
        User current = userService.getById(id);
        return Response.ok().data("roles",permissionList).data("name",current.getNick());
    }

}

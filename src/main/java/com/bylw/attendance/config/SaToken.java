package com.bylw.attendance.config;

import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bylw.attendance.entity.User;
import com.bylw.attendance.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Configuration
public class SaToken implements StpInterface {
    @Resource
    private IUserService userService;

    @Bean
    public StpLogic getStpLogicJwt(){
        return new StpLogicJwtForStyle();
    }

    @Override
    public List<String> getPermissionList(Object loginId, String s) {
        if (StpUtil.isLogin()){
            User permission = userService.getById(loginId.toString());
            String authority = permission.getAuthority();
            String[] split = authority.split(",");
            List<String> permissionList = Arrays.stream(split).collect(Collectors.toList());
            log.error(permissionList.toString());
            return permissionList;
        }
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
//        User permission = userService.getById(loginId.toString());
//        String authority = permission.getAuthority();
//        String[] split = authority.split(",");
//        List<String> permissionList = Arrays.stream(split).collect(Collectors.toList());
//        log.error(permissionList.toString());
        return null;
    }
}

package com.bylw.attendance.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bylw.attendance.entity.vo.LoginVo;
import com.bylw.attendance.entity.User;
import com.bylw.attendance.handle.exceptionhandler.TestException;
import com.bylw.attendance.mapper.UserMapper;
import com.bylw.attendance.service.ILoginService;
import com.bylw.attendance.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User>  implements ILoginService {
    @Resource
    private IUserService userService;


    @Override
    public void login(LoginVo login) {
        String username = login.getEmail();
        String password = login.getPassword();
        QueryWrapper<User> loginWrapper =  new QueryWrapper<>();
        loginWrapper.eq("email",username);
        loginWrapper.eq("u_password",password);
        log.error(userService+"");
        User one = userService.getOne(loginWrapper);
        if(one==null){
            throw new TestException(20002,"登陆失败");
        }

        StpUtil.login(one.getTId());
    }
}

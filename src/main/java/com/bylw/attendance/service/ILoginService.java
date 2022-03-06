package com.bylw.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bylw.attendance.entity.vo.LoginVo;
import com.bylw.attendance.entity.User;

public interface ILoginService extends IService<User> {
    void login(LoginVo login);
}

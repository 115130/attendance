package com.bylw.attendance.service;

import com.bylw.attendance.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
public interface IUserService extends IService<User> {
    void addUser(User user);
    void removeUser(String id);
}

package com.bylw.attendance.service.impl;

import com.bylw.attendance.entity.User;
import com.bylw.attendance.mapper.UserMapper;
import com.bylw.attendance.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.bylw.attendance.service.impl;

import com.bylw.attendance.entity.User;
import com.bylw.attendance.entity.UserInfo;
import com.bylw.attendance.mapper.UserInfoMapper;
import com.bylw.attendance.mapper.UserMapper;
import com.bylw.attendance.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserMapper userMapper;
    private final UserInfoMapper userInfoMapper;

    public UserServiceImpl(UserMapper userMapper,UserInfoMapper userInfoMapper) {
        this.userMapper = userMapper;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
        UserInfo userInfo = new UserInfo();
        String userId = user.getTId();
        userInfo.setUId(userId);
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void removeUser(String id) {
        userMapper.deleteUser(id);
        userInfoMapper.deleteUserInfoByUserId(id);
    }
}

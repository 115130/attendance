package com.bylw.attendance.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.bylw.attendance.entity.User;
import com.bylw.attendance.entity.UserInfo;
import com.bylw.attendance.entity.vo.UserInfoVo;
import com.bylw.attendance.handle.exceptionhandler.TestException;
import com.bylw.attendance.mapper.UserInfoMapper;
import com.bylw.attendance.mapper.UserMapper;
import com.bylw.attendance.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bylw.attendance.utils.RoleCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    private final UserInfoMapper userInfoMapper;
    private final UserMapper userMapper;

    public UserInfoServiceImpl(UserInfoMapper userInfoMapper, UserMapper userMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userMapper = userMapper;
    }

    @Override
    public void updateUserInfo(UserInfoVo userInfoVo) {
        StpUtil.checkPermission(RoleCode.GENERALUSER);
        String id = StpUtil.getLoginIdAsString();
        UserInfo userInfo = new UserInfo();
        userInfo.setUId(id);
        User user = new User();
        user.setTId(userInfoVo.getId());

        BeanUtils.copyProperties(userInfoVo, user);
        BeanUtils.copyProperties(userInfoVo, userInfo);
        int userInfoResult = userInfoMapper.updateUserInfo(userInfo);
        int userResult = userMapper.updateUser(user);

        if (userInfoResult <= 0 && userResult <= 0) {
            throw new TestException(20022,"用户信息更新失败");
        }
    }

    @Override
    public void updateUserInfoByOther(UserInfoVo userInfoVo) {
        StpUtil.checkPermission(RoleCode.ADMINUSER);
        UserInfo userInfo = new UserInfo();
        userInfo.setUId(userInfoVo.getId());
        User user = new User();
        user.setTId(userInfoVo.getId());

        BeanUtils.copyProperties(userInfoVo, user);
        BeanUtils.copyProperties(userInfoVo, userInfo);
        int userInfoResult = userInfoMapper.updateUserInfo(userInfo);
        int userResult = userMapper.updateUser(user);

        if (userInfoResult <= 0 && userResult <= 0) {
            throw new TestException(20022,"用户信息更新失败");
        }
    }

    @Override
    public UserInfoVo getUserInfo() {
        String id = StpUtil.getLoginIdAsString();
        return userInfoMapper.getUserInfoByUserId(id);
    }

    @Override
    public List<UserInfoVo> getUserInfoByOther() {
        return userInfoMapper.getAllUserInfo();
    }
}

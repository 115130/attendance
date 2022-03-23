package com.bylw.attendance.service.impl;

import com.bylw.attendance.entity.User;
import com.bylw.attendance.entity.UserInfo;
import com.bylw.attendance.entity.vo.PermissionVo;
import com.bylw.attendance.mapper.UserInfoMapper;
import com.bylw.attendance.mapper.UserMapper;
import com.bylw.attendance.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bylw.attendance.utils.RoleCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PermissionVo> getPermissionByUserID(String id) {
        List<PermissionVo> list = new ArrayList<>();
        User userById = getById(id);
        String authority = userById.getAuthority();
        String[] split = authority.split(",");

        for (String s : split) {
            switch (s){
                case  RoleCode.GENERALUSER:  list.add(new PermissionVo("普通用户","不可修改个人信息"));
                    break;
                case RoleCode.ADMINUSER:list.add(new PermissionVo("普通用户","可修改个人信息"));
                    break;
                case RoleCode.ADDCLOCKLIMITUSER:list.add(new PermissionVo("签到管理员","可设置签到范围"));
                    break;
                case RoleCode.APPROVEUSER:list.add(new PermissionVo("签到管理员","可审批签到通过"));
                    break;
                case RoleCode.AUTHORITYUSER:list.add(new PermissionVo("权限管理员","可修改权限"));
                    break;
            }
        }
        return list;
    }

    @Override
    public void updatePermission(String roles) {

    }
}

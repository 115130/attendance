package com.bylw.attendance.service;

import com.bylw.attendance.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bylw.attendance.entity.vo.PermissionVo;
import com.bylw.attendance.entity.vo.UserPermissionVo;
import org.springframework.stereotype.Service;

import java.util.List;

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

    List<PermissionVo> getPermissionByUserID(String id);

    void updatePermission(UserPermissionVo role);
}

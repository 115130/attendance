package com.bylw.attendance.service;

import com.bylw.attendance.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bylw.attendance.entity.vo.UserInfoVo;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
public interface IUserInfoService extends IService<UserInfo> {
    void updateUserInfo(UserInfoVo userInfoVo);
    void updateUserInfoByOther(UserInfoVo userInfoVo);
    UserInfoVo getUserInfo();
    List<UserInfoVo> getUserInfoByOther();
}

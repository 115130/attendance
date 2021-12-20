package com.bylw.attendance.service.impl;

import com.bylw.attendance.entity.UserInfo;
import com.bylw.attendance.mapper.UserInfoMapper;
import com.bylw.attendance.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

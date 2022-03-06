package com.bylw.attendance.mapper;

import com.bylw.attendance.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from t_user where email=#{email} and u_password=#{password}")
//    User getUser(LoginVo loginVo);
}

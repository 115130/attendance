package com.bylw.attendance.mapper;

import com.bylw.attendance.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bylw.attendance.entity.vo.UserInfoVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

        @Select("SELECT u.nick,u.email,i.phone,i.gender,i.age FROM t_user AS u LEFT JOIN t_userinfo AS i ON  u.t_id = i.u_id WHERE  u.t_id=#{tId};")
        UserInfoVo getUserInfoByUserId(String tId);

        @Select("SELECT u.nick,u.email,i.phone,i.gender,i.age FROM t_user AS u LEFT JOIN t_userinfo AS i ON  u.t_id = i.u_id")
        List<UserInfoVo> getAllUserInfo();

        @Update("UPDATE t_userinfo set phone=#{phone},gender=#{gender},age=#{age} where u_id=#{uId}")
        int updateUserInfo(UserInfo userInfo);

        @Delete("delete from t_user_info where u_id=#{id}")
        void deleteUserInfoByUserId(String id);
}

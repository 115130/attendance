package com.bylw.attendance.mapper;

import com.bylw.attendance.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("UPDATE t_user set nick=#{nick},email=#{email} where t_id=#{tId}")
    int updateUser(User user);

    @Delete("delete from t_user where t_id=#{tId}")
    int deleteUser(String tId);

    @Insert("INSERT INTO t_user ( nick, email, u_password ) values(#{nick},#{email},#{uPassword})")
    int insertUser(User user);
}

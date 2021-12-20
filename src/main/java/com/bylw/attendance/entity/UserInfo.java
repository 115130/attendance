package com.bylw.attendance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Data
@TableName("t_user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tId;

    @ApiModelProperty("用户id")
    private String uId;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("性别")
    private String gender;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDeleted;

}

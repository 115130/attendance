package com.bylw.attendance.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Data
@TableName("t_authority")
@ApiModel(value = "Authority对象", description = "")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    @ApiModelProperty("权限管理等级（00,普通用户、修改个人信息）（01,查看他人信息,修改其他人个人信息）（10,打卡）（20,修改权限）")
    private String permissionType;



    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改时间")
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    private Integer isDeleted;

}

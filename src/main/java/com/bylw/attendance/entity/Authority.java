package com.bylw.attendance.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
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

    private String tId;

    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty("权限管理等级（1,是否可以设置打卡范围）（2,外勤审判）（3,用户管理）")
    private String permissionType;

}

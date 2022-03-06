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
 * 
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Data
@TableName("t_commute_limit")
@ApiModel(value = "CommuteLimit对象", description = "")
public class CommuteLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    @ApiModelProperty("设置范围人员id")
    private String uId;

    @ApiModelProperty("上维度")
    private Integer upLatitude;

    @ApiModelProperty("下纬度")
    private Integer downLatitude;

    @ApiModelProperty("上经度")
    private Integer upLongitude;

    @ApiModelProperty("下经度")
    private Integer downLongitude;



    @ApiModelProperty("是否删除")
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改时间")
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

}

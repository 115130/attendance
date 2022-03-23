package com.bylw.attendance.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AttendanceVo {
    private String tId;
    @ApiModelProperty("经纬")
    private Integer longitude;

    @ApiModelProperty("纬度")
    private Integer latitude;

    @ApiModelProperty("打卡人员名称")
    private String name;

    @ApiModelProperty("是否在范围内打卡")
    private Integer isCommute;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;
}

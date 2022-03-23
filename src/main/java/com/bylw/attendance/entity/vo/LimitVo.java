package com.bylw.attendance.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LimitVo {
    @ApiModelProperty("上维度")
    private Integer upLatitude;

    @ApiModelProperty("下纬度")
    private Integer downLatitude;

    @ApiModelProperty("上经度")
    private Integer upLongitude;

    @ApiModelProperty("下经度")
    private Integer downLongitude;

    @ApiModelProperty("激活状态")
    private String status;
}

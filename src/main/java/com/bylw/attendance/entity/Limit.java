package com.bylw.attendance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Limit {
    @ApiModelProperty("上维度")
    private Integer upLatitude;

    @ApiModelProperty("上经度")
    private Integer upLongitude;

    @ApiModelProperty("下纬度")
    private Integer downLatitude;

    @ApiModelProperty("下经度")
    private Integer downLongitude;

    public boolean judgeLimit(Integer latitude, Integer longitude){
        boolean b = false;
        if (latitude>=upLatitude && downLatitude>=latitude){
            b=true;
        }
        if (longitude<=upLongitude&&downLongitude<=longitude){
            b=true;
        }
        return b;
    }

}

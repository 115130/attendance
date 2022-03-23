package com.bylw.attendance.controller;


import com.bylw.attendance.entity.vo.LimitVo;
import com.bylw.attendance.service.ICommuteLimitService;
import com.bylw.attendance.service.impl.CommuteLimitServiceImpl;
import com.bylw.attendance.utils.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@RestController
@CrossOrigin
@RequestMapping("/attendance/commutelimit")
public class CommuteLimitController {
    @Autowired
    private ICommuteLimitService commuteLimitService;

    @PostMapping("createLimit")
    public Response createLimit(@RequestBody LimitVo limitVo){
        commuteLimitService.createLimit(limitVo);
        return Response.ok();
    }

    //TODO 激活范围
    @PostMapping("activeLimit")
    public Response activeLimit(String id){
        commuteLimitService.activeLimit(id);
        return Response.ok();
    }

    //TODO 删除已有范围
    @Delete("deleteLimit")
    public Response deleteLimit(String id){
        commuteLimitService.deleteLimit(id);
        return Response.ok();
    }

    //TODO 查看所有范围
    @GetMapping("getAllLimit")
    public Response getAllLimit(){
        List<LimitVo> limitVoList =commuteLimitService.getAllLimit();
        return Response.ok().data("limitVoList",limitVoList);
    }

    //TODO 查看启用范围
    @GetMapping("getAllActiveLimit")
    public Response getAllActiveLimit(){
        List<LimitVo> limitVoList =commuteLimitService.getAllActiveLimit();
        return Response.ok().data("limitVoList",limitVoList);
    }



}

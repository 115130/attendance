package com.bylw.attendance.controller;


import com.bylw.attendance.entity.CommuteRecord;
import com.bylw.attendance.entity.vo.AttendanceVo;
import com.bylw.attendance.service.ICommuteRecordService;
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
@RequestMapping("/attendance/commuterecord")
public class CommuteRecordController {
    @Autowired
    private ICommuteRecordService commuteRecordService;
    // TODO 签到
    @PostMapping("attendance")
    public Response attendance(AttendanceVo attendanceVo){
        commuteRecordService.attendance(attendanceVo);
        return Response.ok();
    }

    // TODO 签到审批通过
    @GetMapping("attendance")
    public Response approvedAttendance(String id){
        commuteRecordService.approvedAttendance(id);
        return Response.ok();
    }

    // TODO 修改签到信息
    @PostMapping("modifyAttendance")
    public Response modifyAttendance(AttendanceVo attendanceVo){
        commuteRecordService.modifyAttendance(attendanceVo);
        return Response.ok();
    }

    // TODO 删除签到
    @Delete("removeAttendance")
    public Response removeAttendance(String id){
        commuteRecordService.removeAttendance(id);
        return Response.ok();
    }

    // TODO 查看所有签到数据
    @GetMapping("getAllAttendance")
    public Response getAllAttendance(){
        List<AttendanceVo> attendanceVo = commuteRecordService.getAllAttendance();
        return Response.ok();
    }

    // TODO 某用户的签到数据
    @GetMapping("getAttendanceByUserId")
    public Response getAttendanceByUserId(String id){
        List<AttendanceVo> attendanceVoList = commuteRecordService.getAttendanceByUserId(id);
        return Response.ok().data("attendanceVoList",attendanceVoList);
    }

    // TODO 获取所有为经过审批的签到记录
    @GetMapping("getAllNotApproved")
    public Response getAllNotApproved(){
        List<AttendanceVo> attendanceVos = commuteRecordService.getAllNotApproved();
        return Response.ok().data("attendanceList",attendanceVos);
    }


}

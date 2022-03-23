package com.bylw.attendance.service;

import com.bylw.attendance.entity.CommuteRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bylw.attendance.entity.vo.AttendanceVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
public interface ICommuteRecordService extends IService<CommuteRecord> {

    void approvedAttendance(String id);

    void modifyAttendance(AttendanceVo attendanceVo);

    void removeAttendance(String id);

    List<AttendanceVo> getAllAttendance();

    List<AttendanceVo> getAttendanceByUserId(String id);

    void attendance(AttendanceVo attendanceVo);

    List<AttendanceVo> getAllNotApproved();
}

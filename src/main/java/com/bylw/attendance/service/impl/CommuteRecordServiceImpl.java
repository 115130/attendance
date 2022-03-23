package com.bylw.attendance.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bylw.attendance.entity.CommuteLimit;
import com.bylw.attendance.entity.CommuteRecord;
import com.bylw.attendance.entity.Limit;
import com.bylw.attendance.entity.vo.AttendanceVo;
import com.bylw.attendance.handle.exceptionhandler.TestException;
import com.bylw.attendance.mapper.CommuteRecordMapper;
import com.bylw.attendance.service.ICommuteLimitService;
import com.bylw.attendance.service.ICommuteRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bylw.attendance.utils.RoleCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Service
public class CommuteRecordServiceImpl extends ServiceImpl<CommuteRecordMapper, CommuteRecord> implements ICommuteRecordService {

    private final ICommuteLimitService commuteLimitService;

    public CommuteRecordServiceImpl(ICommuteLimitService commuteLimitService) {
        this.commuteLimitService = commuteLimitService;

    }

    @Override
    public void attendance(AttendanceVo attendanceVo) {
//        StpUtil.checkPermission(RoleCode.GENERALUSER);
        //获取签到人的id
        String id = StpUtil.getLoginIdAsString();
        CommuteRecord commuteRecord = new CommuteRecord();
        BeanUtils.copyProperties(attendanceVo,commuteRecord);
        commuteRecord.setUId(id);

        //判断签到点是否在范围内
        QueryWrapper<CommuteLimit> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status","1");
        CommuteLimit limit = commuteLimitService.getOne(queryWrapper);
        Limit limit1 = new Limit();
        BeanUtils.copyProperties(limit,limit1);
        boolean complete = limit1.judgeLimit(attendanceVo.getLatitude(), attendanceVo.getLongitude());
        if (complete){
            commuteRecord.setIsCommute(1);
        }else {
            commuteRecord.setIsCommute(0);
        }
        save(commuteRecord);

    }

    @Override
    public List<AttendanceVo> getAllNotApproved() {
        //        StpUtil.checkPermission();

        QueryWrapper<CommuteRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isCommute",0);
        List<AttendanceVo> attendanceVoList = new ArrayList<AttendanceVo>();
        for (CommuteRecord commuteRecord : list(queryWrapper)) {
            AttendanceVo attendanceVo = new AttendanceVo();
            BeanUtils.copyProperties(commuteRecord,attendanceVo);
            attendanceVoList.add(attendanceVo);
        }
        return attendanceVoList;
    }

    @Override
    public void approvedAttendance(String id) {
        //        StpUtil.checkPermission();

        CommuteRecord commuteRecord  = new CommuteRecord();
        commuteRecord.setTId(id);
        commuteRecord.setIsCommute(1);
        updateById(commuteRecord);
    }

    @Override
    public void modifyAttendance(AttendanceVo attendanceVo) {
        //        StpUtil.checkPermission();
        CommuteRecord commuteRecord = new CommuteRecord();
        BeanUtils.copyProperties(attendanceVo,commuteRecord);
        updateById(commuteRecord);
    }

    @Override
    public void removeAttendance(String id) {
//        StpUtil.checkPermission();
        removeById(id);
    }

    @Override
    public List<AttendanceVo> getAllAttendance() {
//        StpUtil.checkPermission();
        List<AttendanceVo> list = new ArrayList<>();
        for (CommuteRecord commuteRecord : list()) {
            AttendanceVo attendanceVo = new AttendanceVo();
            BeanUtils.copyProperties(commuteRecord,attendanceVo);
            list.add(attendanceVo);
        }
        return list;
    }

    @Override
    public List<AttendanceVo> getAttendanceByUserId(String id) {
//        StpUtil.checkPermission();
        List<AttendanceVo> list = new ArrayList<>();
        QueryWrapper<CommuteRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        for (CommuteRecord commuteRecord : list(queryWrapper)) {
            AttendanceVo attendanceVo = new AttendanceVo();
            BeanUtils.copyProperties(commuteRecord,attendanceVo);
            list.add(attendanceVo);
        }

        return list;
    }


}

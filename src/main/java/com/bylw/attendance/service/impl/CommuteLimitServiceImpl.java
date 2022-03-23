package com.bylw.attendance.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bylw.attendance.entity.CommuteLimit;
import com.bylw.attendance.entity.vo.LimitVo;
import com.bylw.attendance.mapper.CommuteLimitMapper;
import com.bylw.attendance.service.ICommuteLimitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bylw.attendance.utils.RoleCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
@Service
public class CommuteLimitServiceImpl extends ServiceImpl<CommuteLimitMapper, CommuteLimit> implements ICommuteLimitService {

    @Override
    public void createLimit(LimitVo limitVo) {
//        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);
        String id = StpUtil.getLoginIdAsString();
        CommuteLimit commuteLimit = new CommuteLimit();
        BeanUtils.copyProperties(limitVo, commuteLimit);
        commuteLimit.setUId(id);
        commuteLimit.setStatus("0");
        save(commuteLimit);


    }

    @Override
    public void activeLimit(String id) {
//        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);
        CommuteLimit commuteLimit = new CommuteLimit();
        commuteLimit.setTId(id);
        commuteLimit.setStatus("1");

        QueryWrapper<CommuteLimit> commuteLimitQueryWrapper =new QueryWrapper<>();
        commuteLimitQueryWrapper.eq("status","1");
        for (CommuteLimit limit : list(commuteLimitQueryWrapper)) {
            limit.setStatus("0");
            updateById(limit);
        }


        updateById(commuteLimit);


    }

    @Override
    public void deleteLimit(String id) {
//        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);
        removeById(id);
    }

    @Override
    public List<LimitVo> getAllActiveLimit() {
//        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);
        List<LimitVo> limitVoList = new ArrayList<>();
        QueryWrapper<CommuteLimit> wrapper = new QueryWrapper<>();
        wrapper.eq("status", "1");
        for (CommuteLimit commuteLimit : list(wrapper)) {
            LimitVo limitVo = new LimitVo();
            BeanUtils.copyProperties(commuteLimit, limitVo);
            limitVoList.add(limitVo);
        }

        return limitVoList;
    }

    @Override
    public List<LimitVo> getAllLimit() {
//        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);

        List<LimitVo> limitVoList = new ArrayList<>();
        for (CommuteLimit commuteLimit : list()) {
            LimitVo limitVo = new LimitVo();
            BeanUtils.copyProperties(commuteLimit, limitVo);
            limitVoList.add(limitVo);
        }

        return limitVoList;
    }

    @Override
    public LimitVo getNewActiveLimit() {
        //        StpUtil.checkPermission(RoleCode.ADDCLOCKLIMITUSER);

        QueryWrapper<CommuteLimit> wrapper = new QueryWrapper<>();
        wrapper.eq("status", "1");
        wrapper.last("ORDER BY gmt_create DESC limit 1");
        CommuteLimit one = getOne(wrapper);
        LimitVo limitVo = new LimitVo();
        BeanUtils.copyProperties(one,limitVo);
        return limitVo;
    }
}

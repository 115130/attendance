package com.bylw.attendance.service;

import com.bylw.attendance.entity.CommuteLimit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bylw.attendance.entity.vo.LimitVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2021-12-20
 */
public interface ICommuteLimitService extends IService<CommuteLimit> {

    void createLimit(LimitVo limitVo);

    void activeLimit(String id);

    void deleteLimit(String id);

    List<LimitVo> getAllActiveLimit();

    List<LimitVo> getAllLimit();

    LimitVo getNewActiveLimit();
}

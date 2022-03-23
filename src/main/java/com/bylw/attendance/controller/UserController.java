package com.bylw.attendance.controller;


import com.bylw.attendance.entity.vo.PermissionVo;
import com.bylw.attendance.entity.vo.UserPermissionVo;
import com.bylw.attendance.service.IUserService;
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
@RequestMapping("/attendance/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Delete("removeUserById")
    public Response removeUserById(String id){
        userService.removeUser(id);
        return Response.ok();
    }

    //TODO 得到一个用户的所有权限列表
    @GetMapping("getPermissionByUserID")
    public Response getPermissionByUserID(String id){
        List<PermissionVo> list = userService.getPermissionByUserID(id);
        return Response.ok().data("permissionList",list);
    }

    //TODO 更新用户所需要的权限
    public Response updatePermission(@RequestBody UserPermissionVo permissionVo){
        userService.updatePermission(permissionVo);
        return Response.ok();
    }
}

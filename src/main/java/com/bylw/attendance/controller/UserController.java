package com.bylw.attendance.controller;


import com.bylw.attendance.service.IUserService;
import com.bylw.attendance.utils.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
}

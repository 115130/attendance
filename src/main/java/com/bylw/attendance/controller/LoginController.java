package com.bylw.attendance.controller;

import com.bylw.attendance.utils.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("attendance/front")
public class LoginController {
    @PostMapping("login")
    public Response login(){

        return Response.ok();
    }
}

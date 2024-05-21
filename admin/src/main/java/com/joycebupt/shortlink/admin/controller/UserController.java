package com.joycebupt.shortlink.admin.controller;

import com.joycebupt.shortlink.admin.dto.resp.UserRespDTO;
import com.joycebupt.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public UserRespDTO getUserInfo(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}

package com.joycebupt.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.joycebupt.shortlink.admin.common.convention.result.Result;
import com.joycebupt.shortlink.admin.common.convention.result.Results;
import com.joycebupt.shortlink.admin.dto.req.UserLoginReqDTO;
import com.joycebupt.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.joycebupt.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.joycebupt.shortlink.admin.dto.resp.UserActualRespDTO;
import com.joycebupt.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.joycebupt.shortlink.admin.dto.resp.UserRespDTO;
import com.joycebupt.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserInfo(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名查询无脱敏用户信息
     */
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserInfo(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * 判断用户名是否存在
     */
    @GetMapping("/api/short-link/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 用户注册
     */
    @PostMapping("/api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/api/short-link/v1/user")
    public Result<Void> updateUser(@RequestBody UserUpdateReqDTO requestParam) {
        userService.updateUser(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("/api/short-link/v1/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

    /**
     * 检查用户是否登录
     */
    @GetMapping("/api/short-link/v1/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }
}

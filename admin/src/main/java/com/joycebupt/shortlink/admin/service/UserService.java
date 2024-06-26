package com.joycebupt.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joycebupt.shortlink.admin.dao.entity.UserDO;
import com.joycebupt.shortlink.admin.dto.req.UserLoginReqDTO;
import com.joycebupt.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.joycebupt.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.joycebupt.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.joycebupt.shortlink.admin.dto.resp.UserRespDTO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 用户名存在返回 True，否则返回 False
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名更新用户信息
     *
     * @param requestParam 更新用户请求参数
     */
    void updateUser(@RequestBody UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     *
     * @param requestParam 登录请求参数
     * @return 用户登录返回参数 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户名是否登录
     *
     * @param username 用户名
     * @param token    用户Token
     * @return 登录返回 True，否则返回 False
     */
    Boolean checkLogin(String username, String token);

    /**
     * 用户登出
     *
     * @param username 用户名
     * @param token    用户Token
     * @return
     */
    void logout(String username, String token);
}

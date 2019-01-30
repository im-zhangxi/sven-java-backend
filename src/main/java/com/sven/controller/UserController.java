package com.sven.controller;

import com.sven.model.UserVo;
import com.sven.service.user.api.UserService;
import com.sven.service.user.api.dto.UserDTO;
import com.sven.service.user.impl.dao.po.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    @ResponseBody
    public WebApiResponse<UserVo> store(@RequestBody User params) {
        String phone = params.getPhone();
        if(StringUtils.isEmpty(phone)){
            return WebApiResponse.error("手机号不能为空");
        }
        String pwd = params.getPwd();
        if(StringUtils.isEmpty(pwd)){
            return WebApiResponse.error("密码不能为空");
        }
        UserDTO user = userService.store(toDTO(params));
        UserVo userVo = toVo(user);
        return WebApiResponse.success(userVo);
    }

    private UserVo toVo(UserDTO user) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

    private UserDTO toDTO(User params) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(params, userDTO);
        return userDTO;
    }

}

package com.sven.controller;

import com.sven.model.UserVo;
import com.sven.service.user.api.UserService;
import com.sven.service.user.api.dto.UserDTO;
import com.sven.service.user.impl.dao.po.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/user")
    @ResponseBody
    public ResponseEntity<UserVo> store(@RequestBody User params) {
        UserDTO user = userService.store(toDTO(params));
        UserVo userVo = toVo(user);
        return new ResponseEntity<>(userVo, HttpStatus.OK);
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

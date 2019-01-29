package com.sven.controller;

import com.sven.entity.User;
import com.sven.dto.UserDto;
import com.sven.service.UserService;
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
    public @ResponseBody ResponseEntity<UserDto> store(@RequestBody User params)
    {
        User user = userService.store(params);
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}

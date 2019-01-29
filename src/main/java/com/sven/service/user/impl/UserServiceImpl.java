package com.sven.service.user.impl;

import com.sven.service.user.api.UserService;
import com.sven.service.user.api.dto.UserDTO;
import com.sven.service.user.impl.dao.po.User;
import com.sven.service.user.impl.dao.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianglong
 * @date 2019/1/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO store(UserDTO userDTO) {
        User user = toPO(userDTO);
        repository.save(user);
        return toDTO(user);
    }

    private User toPO(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}

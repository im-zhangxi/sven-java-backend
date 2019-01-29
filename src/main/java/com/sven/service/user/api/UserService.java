package com.sven.service.user.api;

import com.sven.service.user.api.dto.UserDTO;

/**
 *
 * @author xianglong
 * @date 2019/1/29
 */
public interface UserService {

    /**
     * save user
     * @param userDTO
     * @return
     */
    UserDTO store(UserDTO userDTO);
}

package com.sven.service;

import com.sven.entity.District;
import com.sven.entity.User;
import com.sven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserService {
    @Autowired
    private UserRepository repository;

    public User store(User user)
    {
        return repository.save(user);
    }
}

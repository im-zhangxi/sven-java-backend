package com.sven.service.user.impl.dao.repository;

import com.sven.service.user.impl.dao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xianglong
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.onlineBanking.dao;

import com.onlineBanking.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tigrangyozalyan on 7/19/17.
 */
public interface UserDao extends CrudRepository<User,Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}

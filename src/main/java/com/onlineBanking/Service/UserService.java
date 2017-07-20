package com.onlineBanking.Service;

import com.onlineBanking.domain.User;

/**
 * Created by tigrangyozalyan on 7/19/17.
 */
public interface UserService {

    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);
    boolean checkUserExists(String username, String email);
}

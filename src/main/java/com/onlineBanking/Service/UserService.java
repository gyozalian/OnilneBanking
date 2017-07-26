package com.onlineBanking.Service;

import com.onlineBanking.domain.Security.Role;
import com.onlineBanking.domain.Security.UserRole;
import com.onlineBanking.domain.User;

import java.util.Set;

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

    User createUser(User user, Set<UserRole> userRoles);
}

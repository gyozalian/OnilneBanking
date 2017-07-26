package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Dao.RoleDao;
import com.onlineBanking.Dao.UserDao;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.domain.Security.UserRole;
import com.onlineBanking.domain.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;
import org.slf4j.Logger;


/**
 * Created by tigrangyozalyan on 7/19/17.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void save(User user){
        userDao.save(user);
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public boolean checkUsernameExists(String username){
        if(null != findByUsername(username))
            return true;
        return false;
    }

    public  boolean checkEmailExists(String email){
        if (null != findByEmail(email))
            return true;
        return false;
    }

    public boolean checkUserExists(String username, String email){
        if(checkEmailExists(email) || checkUsernameExists(username))
            return true;
        return false;
    }

    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userDao.findByUsername(user.getUsername());
        if(localUser != null){
            LOG.info("User with UserName {} exist.",user.getUsername());
        }
        else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur: userRoles) {
                roleDao.save(ur.getRole());
                
            }
            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);

        }
        return localUser;
    }
}

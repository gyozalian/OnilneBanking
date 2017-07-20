package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Dao.UserDao;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tigrangyozalyan on 7/19/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

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
}

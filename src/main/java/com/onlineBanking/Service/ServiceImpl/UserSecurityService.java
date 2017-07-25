package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Dao.UserDao;
import com.onlineBanking.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by tigrangyozalyan on 7/25/17.
 */
@Service
public class UserSecurityService implements UserDetailsService {

    /** THE APPLICATION LOGGER */

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUsersByUsername(String username) throws UsernameNotFoundException{
        User user = userDao.findByUsername(username);
        if (null==user){
            LOG.warn("Username {} Not Found",username);
            throw new UsernameNotFoundException("Username "+ username +" Not Found");
        }
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

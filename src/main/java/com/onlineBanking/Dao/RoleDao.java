package com.onlineBanking.Dao;

import com.onlineBanking.domain.Security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tigrangyozalyan on 7/26/17.
 */
public interface RoleDao extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}

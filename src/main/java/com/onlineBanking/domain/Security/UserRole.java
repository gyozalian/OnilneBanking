package com.onlineBanking.domain.Security;

import com.onlineBanking.domain.User;

import javax.persistence.*;

/**
 * Created by tigrangyozalyan on 7/20/17.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole(){}

    public Long getUserRoleid() {
        return userRoleid;
    }

    public void setUserRoleid(Long userRoleid) {
        this.userRoleid = userRoleid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

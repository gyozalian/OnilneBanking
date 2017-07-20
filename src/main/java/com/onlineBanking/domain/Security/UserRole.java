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
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}

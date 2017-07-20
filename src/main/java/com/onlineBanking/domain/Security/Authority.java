package com.onlineBanking.domain.Security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by tigrangyozalyan on 7/20/17.
 */
public class Authority implements GrantedAuthority{

    private final String authority;

    public Authority(String authority){
        this.authority = authority;
    }

    @Override
    public String  getAuthority(){
        return authority;
    }
}

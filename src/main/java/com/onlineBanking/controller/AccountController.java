package com.onlineBanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tigrangyozalyan on 9/2/17.
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/primaryAccount")
    public String primaryAccount(){
        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String savingsAccount(){
        return "savingsAccount";
    }
}

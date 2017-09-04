package com.onlineBanking.controller;

import com.onlineBanking.Service.AccountService;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.domain.PrimaryAccount;
import com.onlineBanking.domain.SavingsAccount;
import com.onlineBanking.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.security.Principal;

/**
 * Created by tigrangyozalyan on 9/2/17.
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount",primaryAccount);

        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount",savingsAccount);

        return "savingsAccount";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String depositGet(Model model){
        model.addAttribute("accountType","");
        model.addAttribute("amount","");

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPost(@ModelAttribute("amount") String amount,
                              @ModelAttribute("accountType") String accountType,
                              Principal principal){
        accountService.deposit(accountType,Double.parseDouble(amount),principal);
        return "redirect:/userFront";

    }


    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdrawGet(Model model){
        model.addAttribute("accountType","");
        model.addAttribute("amount","");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw",method = RequestMethod.POST)
    public String withdrawPost(@ModelAttribute("amount") String amount,
                               @ModelAttribute("accountType") String accountType,
                               Principal principal){
        accountService.withdraw(accountType,Double.parseDouble(amount),principal);

        return "redirect:/userFront";
    }
}

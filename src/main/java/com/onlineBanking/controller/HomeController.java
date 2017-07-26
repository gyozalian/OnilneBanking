package com.onlineBanking.controller;

import com.onlineBanking.Service.UserService;
import com.onlineBanking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tigrangyozalyan on 7/8/17.
 */

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        User user = new User();

        model.addAttribute("user",user);

        return "signup";

    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model){

        if(userService.checkUserExists(user.getUsername(),user.getEmail())){

            if(userService.checkUsernameExists(user.getUsername())){
              model.addAttribute("Username Exists", true);
            }

            if (userService.checkEmailExists(user.getEmail()))
            {
                model.addAttribute("Email Exists",true);
            }

            return "signup";

        }

        else {
                userService.createUser(user);
//            Set<UserRole> userRoles = new HashSet<>();
//            userRoles.add(new UserRole(user, roleDao.findByName("USER")));
//            userService.createUser(user, userRoles);

            return "redirect:/";

        }
    }
}

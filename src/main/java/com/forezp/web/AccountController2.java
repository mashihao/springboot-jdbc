package com.forezp.web;

import com.forezp.dao.IAccountDAO;
import com.forezp.entity.User;
import com.forezp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author msh
 * @time 2017/11/23 20:55
 */

@RestController
@RequestMapping("/account2")
public class AccountController2 {

    @Autowired
    IAccountDAO accountService;

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username") String user, @RequestParam(value = "password") String pass) {
        if (user.equals(pass)) {
            return "succ";
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getAccountById(@PathVariable("username") String username) {
        return userRepository.findByName(username);
    }


}

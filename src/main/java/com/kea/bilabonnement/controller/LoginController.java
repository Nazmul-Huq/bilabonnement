package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.repo.LoginRepo;
import com.kea.bilabonnement.repo.LoginRepoImpl;
import com.kea.bilabonnement.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/login")
public class LoginController {


    private final LoginRepo loginRepo = new LoginRepoImpl();
    private final LoginService loginService = new LoginService(loginRepo);

    @GetMapping("/login-customer")
    public String loginCustomer(){
        return "/login/login-customer";
    }

    @PostMapping("/login-customer")
    public String loginCustomerHandler(@RequestParam String username, @RequestParam String password){
        int isLoginValid = loginService.verifyCustomerLogin(username, password);
        if (isLoginValid != 0) {
            return "redirect:/customer/profile-customer";
        } else {
            return "redirect:/login/login-customer";
        }
    }

    @GetMapping("/login-employee")
    public String loginEmployee(){
        return "/login/login-employee";
    }


    @PostMapping("/login-employee")
    public String loginEmployeeHandler(@RequestParam String username, @RequestParam String password){
        int isLoginValid = loginService.verifyEmployeeLogin(username, password);
        if (isLoginValid != 0) {
            return "redirect:/employee/profile-employee";
        } else {
            return "redirect:/login/login-employee";
        }
    }


}

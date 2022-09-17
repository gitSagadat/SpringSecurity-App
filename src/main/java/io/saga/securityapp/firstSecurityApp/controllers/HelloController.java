package io.saga.securityapp.firstSecurityApp.controllers;

import io.saga.securityapp.firstSecurityApp.security.PersonDetails;
import io.saga.securityapp.firstSecurityApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private final AdminService adminService;
    @Autowired
    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String sayHello (){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "Hello";
    }
    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminDelegate();
        return "admin";
    }
}

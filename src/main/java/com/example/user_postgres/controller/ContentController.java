package com.example.user_postgres.controller;

import com.example.user_postgres.model.MyUser;
import com.example.user_postgres.model.MyUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ContentController {

    @Autowired
    private MyUserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/sql")
    public String sql(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("name", username);

        List<MyUser> table = userRepository.findAllUsers();

        model.addAttribute("users", table);
        return "sql";
    }

}
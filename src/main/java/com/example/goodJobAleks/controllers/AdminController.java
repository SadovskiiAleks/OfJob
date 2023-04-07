package com.example.goodJobAleks.controllers;

import com.example.goodJobAleks.models.Permission;
import com.example.goodJobAleks.models.Role;
import com.example.goodJobAleks.models.User;
import com.example.goodJobAleks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getMain(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "admin-main";
    }

    @PostMapping("/post")
    public String postStatePost(@Param("id") long id,
                                @Param("rights") String rights,
                                Model model) {
        User user = userRepository.findById(id).orElseThrow();

        //ДОБАВИТЬ ПОЛУЧЕНИЕ РОЛИ ОТ ПОСТ ЗАПРОСА
        switch (rights) {
            case  ("USER"):
                user.setRole(Role.USER);
                break;
            case ("OPERATOR"):
                user.setRole(Role.OPERATOR);
                break;
            case ("ADMIN"):
                user.setRole(Role.ADMIN);
                break;
            case ("OPERATOR_USER"):
                user.setRole(Role.OPERATOR_USER);
                break;
            case ("OPERATOR_ADMIN"):
                user.setRole(Role.OPERATOR_ADMIN);
                break;
            case ("USER_ADMIN"):
                user.setRole(Role.USER_ADMIN);
                break;
            case ("USER_OPERATOR_ADMIN"):
                user.setRole(Role.USER_OPERATOR_ADMIN);
                break;
            default:
                break;
        }

        userRepository.save(user);
        return "redirect:/admin";
    }
}


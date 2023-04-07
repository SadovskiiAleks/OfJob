package com.example.goodJobAleks.restContollers;

import com.example.goodJobAleks.models.UserOfDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<UserOfDB> USERS = Stream.of(
            new UserOfDB(1L,"user","USER",true,false,false),
            new UserOfDB(2L,"operator","OPERATOR",false,true,false),
            new UserOfDB(3L,"admin","ADMIN",false,false,true)
    ).collect(Collectors.toList());

    @GetMapping
    public List<UserOfDB> getAll() {
        return USERS;
    }

    @GetMapping("/{id}")
    public UserOfDB getByID(@PathVariable Long id) {
        return USERS.stream().filter(UserOfDB -> UserOfDB.getId().equals(id))
                .findFirst().orElse(null);
    }
}

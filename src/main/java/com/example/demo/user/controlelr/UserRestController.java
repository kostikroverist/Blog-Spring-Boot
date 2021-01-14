package com.example.demo.user.controlelr;

import com.example.demo.user.service.UserService;
import com.example.demo.user.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAll(){
        return userService.getAll();
    }
//
//
    @GetMapping(params = {"name"})
    public List<UserEntity> findByName(@Param("name") String name){
        return userService.findByName(name);
    }

    @GetMapping("/findMoreArticles")
    public List<String> findMoreThreeArticles() {
        return userService.findMoreThreeArticles();
    }

    @GetMapping("/findColor/{name}")
    public List<UserEntity> findbyColor(@PathVariable(name = "name")String name ) {
        return userService.findByColor(name);
    }

    @GetMapping("/user/{age}")
    public List<UserEntity>findbyage(@PathVariable(name = "age") int age){
        return userService.findOlderUser(age);
    }

    @PostMapping("/saveUser")
    public UserEntity save (@RequestBody UserEntity users){
        return userService.save(users);
    }

}

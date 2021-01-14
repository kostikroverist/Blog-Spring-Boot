package com.example.demo.article.controller;

import com.example.demo.config.AuthRequesr;
import com.example.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerResource {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager  authenticationManager;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }


    @PostMapping("/authenticate")
    public  String generareToken(@RequestBody AuthRequesr authRequesr) throws Exception {
try {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequesr.getUserName(), authRequesr.getPassword())
    );
} catch (Exception exception){
    throw new Exception("inavalid userna/passwrd");
}
return  jwtUtil.generateToken(authRequesr.getUserName());
}
}

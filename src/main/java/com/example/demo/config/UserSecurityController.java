package com.example.demo.config;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public interface UserSecurityController extends JpaRepository<User,Long> {

    User findByUserName(String userName);

}

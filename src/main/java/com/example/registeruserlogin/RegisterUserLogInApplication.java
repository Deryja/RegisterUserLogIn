package com.example.registeruserlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class RegisterUserLogInApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterUserLogInApplication.class, args);
    }

}
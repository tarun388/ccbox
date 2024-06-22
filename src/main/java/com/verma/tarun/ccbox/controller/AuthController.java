package com.verma.tarun.ccbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verma.tarun.ccbox.model.User;
import com.verma.tarun.ccbox.repository.UserRepository;


@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestParam String name, @RequestParam String password) {
        log.info("Request: /signup {}", name);
        User user = userRepository.findByName(name);
        if (user != null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
        user = userRepository.save(new User(name, password));
        return ResponseEntity.ok("Sign up successful");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String name, @RequestParam String password) {
        log.info("Request: /login {}", name);
        User user = userRepository.findByName(name);
        if (user == null) {
            log.info("User {} doesn't exist", name);
            return ResponseEntity.notFound().build();
        } else if (!user.getPassword().equals(password)) {
            log.info("User {} not auth {}", name, password);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Login successful");
    }
    
}

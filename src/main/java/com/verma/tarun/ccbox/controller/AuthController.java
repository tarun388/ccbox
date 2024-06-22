package com.verma.tarun.ccbox.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestParam String name) {
        System.out.println(name);
        return ResponseEntity.ok("Sign up successful");
    }
    
}

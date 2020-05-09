package com.simple.jwt.controllers;

import com.simple.jwt.dto.AuthDTO;
import com.simple.jwt.model.JwtUser;
import com.simple.jwt.services.JwtService;
import com.simple.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JWTController
{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping(value = "/")
    public ResponseEntity<?> sayHello()
    {
        String result = String.format("Hello world!");
        return ResponseEntity.ok(result);
    }
    
    @GetMapping(value = "/api/auth/hello/{name}")
    public ResponseEntity<?> helloSecure(@PathVariable String name)
    {
        String result = "Hello (Authorized) "+name;
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/api/public/hello/{name}")
    public ResponseEntity<?> helloPublic(@PathVariable String name)
    {
        String result = "Hello (Public) "+name;
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/api/public/generate-token")
    public ResponseEntity<?> auth(@RequestBody AuthDTO auth) {
    	
        String userName = auth.getUserName();
        String passWord = auth.getPassWord();
        Boolean correctCredentials = userService.authenticate(userName, passWord);
        if (correctCredentials) {
            JwtUser jwtUser = new JwtUser(userName, passWord);
            return ResponseEntity.ok(jwtService.getToken(jwtUser));
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}

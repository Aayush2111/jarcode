package com.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@CrossOrigin(origins = "*")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("{\"name\":\"aayush\"}");
    }

}

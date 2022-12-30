package com.learnbasicjava.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping(value = "/status")
    public String checkStatus() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("Status", "running");
        map.put("Datetime", String.valueOf(new Date()));
        return new ObjectMapper().writeValueAsString(map);
    }
}

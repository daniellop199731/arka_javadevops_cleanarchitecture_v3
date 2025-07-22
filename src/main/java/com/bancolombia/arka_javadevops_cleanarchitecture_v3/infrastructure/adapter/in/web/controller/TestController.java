package com.bancolombia.arka_javadevops_cleanarchitecture_v3.infrastructure.adapter.in.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public String test() {
        return "Hello, this is a test endpoint!";
    }

    @GetMapping("/{text}")
    public String testPath(@PathVariable("text") String text) {
        return "Hello, this is a test endpoint with path-parameter: " + text;
    }
    
    @GetMapping("/with-param")
    public String testParam(@RequestParam("param") String param) {
        return "Hello, this is a test endpoint with request-parameter: " + param;
    }

    @GetMapping("/with-body")
    public String testBody(@RequestBody String param) {
        return "Hello, this is a test endpoint with request-body: \n" + param;
    }
    
    

}


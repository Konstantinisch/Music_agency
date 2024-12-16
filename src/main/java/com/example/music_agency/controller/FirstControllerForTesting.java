package com.example.music_agency.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/test")
public class FirstControllerForTesting {

    @GetMapping("/getTestController")
    public String getStr(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("Get Header: " + request.getHeader("User-Agent"));
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("JSESSION".equals(cookie.getName())) {
                System.out.printf("JSESSION: " + cookie.getValue());
            }
            System.out.printf("Cookie: " + cookie.getValue());
        }
        System.out.println("STATUS: " + response.getStatus());
        return "Hello World";


    }





}

package com.sof306.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("accounts/list")
    public String index() {
        return "";
    }
}

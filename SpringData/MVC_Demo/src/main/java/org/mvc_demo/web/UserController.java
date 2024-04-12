package org.mvc_demo.web;

import jakarta.validation.Valid;
import org.mvc_demo.web.dtos.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/something")
    public String something() {
        return "something";
    }

    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }



    @PostMapping("/users/login")
    public String doLogin(@Valid UserLoginDto userLoginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

        }

        return "user/login";
    }
}

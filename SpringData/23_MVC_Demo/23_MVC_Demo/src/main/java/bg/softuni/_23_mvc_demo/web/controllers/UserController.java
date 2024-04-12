package bg.softuni._23_mvc_demo.web.controllers;

import bg.softuni._23_mvc_demo.web.dtos.UserLoginDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

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

    // Without binding result the request is rejected with 400 response code
    @PostMapping("/users/login")
    public String doLogin(@Valid UserLoginDTO loginDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // do some error handling
            return "user/login";
        }

        // Do actual login
        return "redirect:/home";
    }
}

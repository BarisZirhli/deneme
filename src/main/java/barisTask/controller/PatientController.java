package barisTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PatientController {

    @PostMapping("/register")
    public String register(Model model) {

        return "register";
    }

    @PostMapping("/login")
    public String login() {
        return "login";
    }

}

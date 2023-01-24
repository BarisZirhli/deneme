package barisTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/register")
    public String register() {
        //model.addAttribute("attribute", "value");
        return "register";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}

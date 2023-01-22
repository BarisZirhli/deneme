package barisTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/home")
    public String page() {
        //model.addAttribute("attribute", "value");
        return "baris.html";
    }

}

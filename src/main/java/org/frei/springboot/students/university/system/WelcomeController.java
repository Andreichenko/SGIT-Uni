package org.frei.springboot.students.university.system;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}

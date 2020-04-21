package madamwebchange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyMadamController {

    @GetMapping("/mymadam")
    public String mymadam(){
        return "mymadam";
    }

}

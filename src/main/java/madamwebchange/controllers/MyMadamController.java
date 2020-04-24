package madamwebchange.controllers;

import madamwebchange.MyMadam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyMadamController {

    @GetMapping("/mymadam")
    public String mymadamCreate(Model model) {
        model.addAttribute("mymadam", new MyMadam());
        return "mymadam";
    }

    @PostMapping("/mymadam-save")
    public String mymadamSave(@ModelAttribute MyMadam myMadam) {
        return "result";
    }

}

package madamwebchange.controllers;

import madamwebchange.MyMadam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class MyMadamController {

    public static String email;

    @GetMapping("/mymadam")
    public String mymadamCreate(Model model) {
        model.addAttribute("mymadam", new MyMadam());

        return "mymadam";
    }

    @PostMapping("/mymadam-save")
    public String mymadamSave(@ModelAttribute MyMadam myMadam) throws IOException {
        File properties = new File("properties.txt");
        FileWriter fileWriter = new FileWriter("properties.txt");
        fileWriter.append(myMadam.getLink())
                .append(System.lineSeparator())
                .append(myMadam.getFrequency().toString())
                .append(System.lineSeparator())
                .write(myMadam.getEmail());
        fileWriter.close();
        return "result";
    }

}

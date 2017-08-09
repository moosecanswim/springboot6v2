package me.moosecanswim.springboot06.Controller;

import me.moosecanswim.springboot06.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("song", new Song());
        return "index";
    }
    @GetMapping("/songform")
    public String loadFormPage(Model model){
        model.addAttribute("song", new Song());
        return "songform";
    }
    @PostMapping("/songform")
    public String loadFromPage(@ModelAttribute Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            String messageToSend = "There was an issue with the employee added.  Please try again";
            System.out.println("**Here is an issue**"  + bindingResult.toString());
            return "/songform";
        }
        return "confirmsong";
    }

}

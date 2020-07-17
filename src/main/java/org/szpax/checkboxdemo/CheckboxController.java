package org.szpax.checkboxdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckboxController {


    @GetMapping("/show-me-the-form")
    public String form(Model model, @RequestParam(defaultValue = "false") boolean initial){
        CheckboxWrapper checkboxWrapper = new CheckboxWrapper();
        checkboxWrapper.setWasIChecked(initial);
        model.addAttribute("checkboxWrapper", checkboxWrapper);
        return "checkbox";
    }

    @PostMapping("/save-checkbox")
    public String save(CheckboxWrapper checkboxWrapper) {
        System.out.println("Was it checked?! " + checkboxWrapper.isWasIChecked());
        return "redirect:/show-me-the-form";
    }

}

package com.online_ordering.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView Home(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home/index");

        return modelAndView;
    }
}
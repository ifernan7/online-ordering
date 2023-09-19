package com.online_ordering.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.online_ordering.domain.User;
import com.online_ordering.infrastructure.abstractions.IUserService;

@Controller
public class HomeController {

    //@Autowired
    private final IUserService _userService;

    public HomeController(IUserService userService) {
        this._userService = userService;
    }

    //@GetMapping("/Home")
    @GetMapping("/")
    public ModelAndView Home(Model model) {
        System.out.println("i'm inside the Home Method of the home controller!!");
        String test = _userService.GetUserByEmail();
        System.out.println(test);

        System.out.println("In Home Controller");

        User ismael = new User();
        ismael.setName(test);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", ismael);
        modelAndView.setViewName("home");

        return modelAndView;
    }

  @GetMapping("/User")
     public ModelAndView User(Model model) {
         System.out.println("In Home Controller");

         //UserRepository repository = new UserRepository();

        // String user = repository.GetUserByEmail();

         User ismael = new User();
         ismael.setName("Gabe");

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("user",ismael);
         modelAndView.setViewName("user/index");

         return modelAndView;
     }
}
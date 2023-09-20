package com.online_ordering.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.online_ordering.domain.User;
import com.online_ordering.infrastructure.abstractions.IUserService;

import java.util.List;

@Controller
public class HomeController {

    private final IUserService _userService;

    public HomeController(IUserService userService) {
        this._userService = userService;
    }

    //@GetMapping("/Home")
    @GetMapping("/")
    public ModelAndView Home(Model model) {

        System.out.println("Inside the Home Method inside the HomeController . . .");

        List<User> users = _userService.GetAllUsers();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users", users);

        modelAndView.setViewName("home");

        return modelAndView;
    }

  @GetMapping("/User")
     public ModelAndView User(Model model) {
         System.out.println("In Home Controller");

         //UserRepository repository = new UserRepository();

        // String user = repository.GetUserByEmail();

         User ismael = new User();
         //ismael.setName("Gabe");

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("user",ismael);
         modelAndView.setViewName("user/index");

         return modelAndView;
     }
}
package com.online_ordering.user;

import com.online_ordering.user.abstractions.IUserService;
import com.online_ordering.user.dtos.CreateUserDTO;
import com.online_ordering.user.dtos.UpdateUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {
    private final IUserService _userService;

    public UserController(IUserService userService) {
        this._userService = userService;
    }

    @GetMapping("/user")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = _userService.GetAllUsers();

        modelAndView.addObject("users", users);

        modelAndView.setViewName("user/index");
        return modelAndView;
    }

    @GetMapping("/user/delete/{id}")
    public RedirectView Delete(@PathVariable int id) {

        _userService.DeleteUserById(id);

        return new RedirectView("/user");
    }

    @GetMapping("/user/create")
    public ModelAndView Create() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/create");

        return modelAndView;
    }

    @PostMapping("/user/create")
    public RedirectView Create(CreateUserDTO model) {

        _userService.AddUser(model.getEmail(), model.getPassword());

        return new RedirectView("/user");
    }

    @GetMapping("/user/update/{id}")
    public ModelAndView Update(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();

        User user = _userService.GetUserById(id);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("user/update");

        return modelAndView;
    }

    @PostMapping("/user/update")
    public RedirectView updateUser(UpdateUserDTO model) {

        _userService.UpdateUserEmailById(model.getId(), model.getEmail());

        return new RedirectView("/user");
    }
}
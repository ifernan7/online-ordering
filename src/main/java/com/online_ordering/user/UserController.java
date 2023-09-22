package com.online_ordering.user;

import com.online_ordering.user.User;
import com.online_ordering.user.abstractions.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}

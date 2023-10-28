package com.online_ordering.user;

import com.online_ordering.user.abstractions.IUserService;
import com.online_ordering.user.dtos.CreateUserDTO;
import com.online_ordering.user.dtos.UpdateUserDTO;
import com.online_ordering.utilities.Response;
import com.online_ordering.utilities.ViewModelBase;
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

        ViewModelBase<CreateUserDTO> viewModel = new ViewModelBase<CreateUserDTO>(new CreateUserDTO(), null);

        return new ModelAndView("user/create","viewModel",viewModel);
    }

    @PostMapping("/user/create")
    public Object Create(CreateUserDTO model) {

        Response<Boolean> response = _userService.AddUser(model.getEmail(), model.getPassword());

        if(!response.getData()) {

            ViewModelBase<CreateUserDTO> viewModel = new ViewModelBase<CreateUserDTO>(model, response.getMessage());

            return new ModelAndView("user/create", "viewModel", viewModel);
        }

        return new RedirectView("/user");
    }

    @GetMapping("/user/update/{id}")
    public ModelAndView Update(@PathVariable int id) {

        User user = _userService.GetUserById(id);

        ViewModelBase<User> viewModel = new ViewModelBase<User>(user, null);

        return new ModelAndView("user/update", "viewModel", viewModel);
    }

    @PostMapping("/user/update")
    public Object Update(UpdateUserDTO model) {

        Response<Boolean> response = _userService.UpdateUserEmailById(model.getId(), model.getEmail());

        if(!response.getData()){

            User user = _userService.GetUserById(model.getId());

            ViewModelBase<User> viewModel = new ViewModelBase<User>(user, response.getMessage());

            return new ModelAndView("user/update", "viewModel", viewModel);
        }

        return new RedirectView("/user");
    }
}
Here I'm adding bad code on purpose to trigger a build failure to test the ci pipeline..
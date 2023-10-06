package com.online_ordering.product;

import com.online_ordering.user.User;
import com.online_ordering.user.abstractions.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/product")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/index");
        return modelAndView;
    }

}

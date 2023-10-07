package com.online_ordering.product;

import com.online_ordering.product.abstractions.IProductService;
import com.online_ordering.user.User;
import com.online_ordering.user.abstractions.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private final IProductService _productService;

    public ProductController(IProductService productService){
        this._productService = productService;
    }

    @GetMapping("/product")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        List<Product> products = _productService.GetAllProducts();


        modelAndView.addObject("products", products);

        modelAndView.setViewName("product/index");
        return modelAndView;
    }

}

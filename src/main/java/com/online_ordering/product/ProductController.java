package com.online_ordering.product;

import com.online_ordering.product.abstractions.IProductService;
import com.online_ordering.product.dtos.CreateProductDTO;
import com.online_ordering.product.dtos.UpdateProductDTO;
import com.online_ordering.utilities.Response;
import com.online_ordering.utilities.ViewModelBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/product/delete/{id}")
    public RedirectView Delete(@PathVariable int id){
        _productService.DeleteProductFromID(id);

        return new RedirectView("/product");
    }

    @GetMapping("/product/create")
    public ModelAndView Create() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/create");

        return modelAndView;
    }

    @PostMapping("/product/create")
    public RedirectView Create(CreateProductDTO model) {

        _productService.AddProduct(model.getName(), model.getDescription(), model.getPrice());

        return new RedirectView("/product");
    }

    @GetMapping("/product/update/{id}")
    public ModelAndView Update(@PathVariable int id) {

        Product product = _productService.GetProductFromID(id);

        ViewModelBase<Product> viewModel = new ViewModelBase<Product>(product, null);

        return new ModelAndView("product/update", "viewModel", viewModel);
    }

    @PostMapping("/product/update")
    public Object Update(UpdateProductDTO model) {

        Response<Boolean> response = _productService.ModifyProduct(model.getId(), model.getName(), model.getDescription(), model.getPrice());

        if(!response.getData()){

            Product product = _productService.GetProductFromID(model.getId());

            ViewModelBase<Product> viewModel = new ViewModelBase<Product>(product, response.getMessage());

            return new ModelAndView("product/update", "viewModel", viewModel);
        }

        return new RedirectView("/product");
    }


}

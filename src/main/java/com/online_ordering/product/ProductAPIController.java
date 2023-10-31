package com.online_ordering.product;


import com.online_ordering.order.Order;
import com.online_ordering.order.abstractions.IOrderService;
import com.online_ordering.product.abstractions.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPIController {

    private final IProductService _productService;

    public ProductAPIController(IProductService productService) {
        this._productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> GetAllProducts() {
        List<Product> products = _productService.GetAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}

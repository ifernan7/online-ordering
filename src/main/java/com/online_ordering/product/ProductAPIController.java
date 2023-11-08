package com.online_ordering.product;


import com.online_ordering.order.Order;
import com.online_ordering.order.OrderProduct;
import com.online_ordering.order.abstractions.IOrderService;
import com.online_ordering.product.abstractions.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPIController {


    private final IProductService _productService;

    private final IOrderService _orderService;

    public ProductAPIController(IProductService productService, IOrderService orderService) {
        this._productService = productService;
        this._orderService = orderService;
    }

    @GetMapping("/products/{orderId}")
    public ResponseEntity<Object> GetAllProducts(@PathVariable int orderId) {
        List<Product> products = _productService.GetAllProducts();
        List<OrderProduct> productsOnOrder = _orderService.GetProductsOnOrder(orderId);

        for(int i = 0; i < products.size(); i++){
            int productID = products.get(i).getId();
            for(int j = 0; j < productsOnOrder.size(); j++){
                if (productID == productsOnOrder.get(j).getId()){
                    products.remove(i);
                }
            }
        }


        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}

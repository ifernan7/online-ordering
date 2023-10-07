package com.online_ordering.product;

import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.product.abstractions.IProductRepository;
import com.online_ordering.product.abstractions.IProductService;
import com.online_ordering.user.UserService;
import com.online_ordering.utilities.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    private final IProductRepository _productRepository;
    private final IOrderRepository _orderRepository;


    public ProductService(IProductRepository productRepository, IOrderRepository orderRepository){
        this._productRepository = productRepository;
        this._orderRepository = orderRepository;
    }

    public List<Product> GetAllProducts(){
        return _productRepository.GetAllProducts();
    }


    public void GetProductFromID(int id) {

    }


    public void AddProduct(String name, String description, String price) {

    }


    public Response<Boolean> ModifyProduct(int id, String name, String description, String price) {
        return null;
    }


    public void DeleteProductFromID(int id) {

    }


}

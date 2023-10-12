package com.online_ordering.product;

import com.online_ordering.order.Order;
import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.product.abstractions.IProductRepository;
import com.online_ordering.product.abstractions.IProductService;
import com.online_ordering.utilities.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository _productRepository;
    private final IOrderRepository _orderRepository;

    public ProductService(IProductRepository productRepository, IOrderRepository orderRepository) {
        this._productRepository = productRepository;
        this._orderRepository = orderRepository;
    }

    public List<Product> GetAllProducts() {
        return _productRepository.GetAllProducts();
    }

    public Product GetProductFromID(int id) {
        return _productRepository.GetProductFromID(id);
    }

    public void AddProduct(String name, String description, String price) {
        _productRepository.AddProduct(name, description, price);
    }

    public Response<Boolean> ModifyProduct(int id, String name, String description, String price) {

        //doing name for now
        if (!name.isEmpty() || !name.isBlank()) {
            _productRepository.ModifyProduct(id, name, description, price);
            return new Response<Boolean>(true, "Update Succeeded");
        }

        return new Response<Boolean>(false, "Update Failed");
    }

    public void DeleteProductFromID(int id) {

        Order order = _orderRepository.GetOrderById(id);

        if (order == null) {
            _productRepository.DeleteProductFromID(id);
        }
    }
}
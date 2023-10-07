package com.online_ordering.product.abstractions;

import com.online_ordering.product.Product;
import com.online_ordering.utilities.Response;

import java.util.List;
public interface IProductService {

    List<Product> GetAllProducts();

    Product GetProductFromID(int id);

    void AddProduct(String name, String description, String price);

    Response<Boolean> ModifyProduct(int id, String name, String description, String price);

    void DeleteProductFromID(int id);

}

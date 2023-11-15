package com.online_ordering.presentation;

import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.product.Product;
import com.online_ordering.product.ProductService;
import com.online_ordering.product.abstractions.IProductRepository;
import com.online_ordering.utilities.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductServiceTests {
	@Test
	public void GetAllProducts_returns_all_Products() {

		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository order = Mockito.mock(IOrderRepository.class);


		List<Product> products = new ArrayList<>();

		Product Keyboard = new Product();
		Keyboard.setId(1);
		Keyboard.setName("Computer Keyboard");
		Keyboard.setDescription("A standard keyboard meant for use on computers");
		Keyboard.setPrice("19.99");
		Keyboard.setOnOrder(false);

		Product Mouse = new Product();
		Keyboard.setId(2);
		Keyboard.setName("Computer Mouse");
		Keyboard.setDescription("A standard mouse meant for use on computers");
		Keyboard.setPrice("10.99");
		Keyboard.setOnOrder(false);

		Product Monitor = new Product();
		Keyboard.setId(3);
		Keyboard.setName("Computer Monitor");
		Keyboard.setDescription("A standard Monitor meant for use on computers");
		Keyboard.setPrice("49.99");
		Keyboard.setOnOrder(true);

		Product Computer = new Product();
		Keyboard.setId(4);
		Keyboard.setName("Computer");
		Keyboard.setDescription("A standard computer that takes standard parts");
		Keyboard.setPrice("199.99");
		Keyboard.setOnOrder(true);

		products.add(Keyboard);
		products.add(Mouse);
		products.add(Monitor);
		products.add(Computer);

		when(productRepository.GetAllProducts()).thenReturn(products);

		ProductService productService = new ProductService(productRepository, order);

		List<Product> result = productService.GetAllProducts();

		assertEquals(products.size(), result.size());
	}


	@Test
	public void AddProduct_doesnt_add_product_when_no_name(){
		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository orderRepository = Mockito.mock(IOrderRepository.class);

		ProductService productService = new ProductService(productRepository, orderRepository);

		Response<Boolean> response = productService.AddProduct("", "TestProductDescription", "99.99");

		assertEquals(false, response.getData());
	}

	@Test
	public void AddProduct_doesnt_add_product_when_no_description(){
		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository orderRepository = Mockito.mock(IOrderRepository.class);

		ProductService productService = new ProductService(productRepository, orderRepository);

		Response<Boolean> response = productService.AddProduct("TestProductName", "", "99.99");

		assertEquals(false, response.getData());
	}

	@Test
	public void AddProduct_doesnt_add_product_when_no_price(){
		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository orderRepository = Mockito.mock(IOrderRepository.class);

		ProductService productService = new ProductService(productRepository, orderRepository);

		Response<Boolean> response = productService.AddProduct("TestProductName", "TestProductDescription", "");

		assertEquals(false, response.getData());
	}

	@Test
	public void AddProduct_doesnt_add_product_when_not_number_price(){
		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository orderRepository = Mockito.mock(IOrderRepository.class);

		ProductService productService = new ProductService(productRepository, orderRepository);

		Response<Boolean> response = productService.AddProduct("TestProductName", "TestProductDescription", "Not A Number");

		assertEquals(false, response.getData());
	}

	@Test
	public void AddProduct_doesnt_add_product_when_price_less_than_zero(){
		IProductRepository productRepository = Mockito.mock(IProductRepository.class);
		IOrderRepository orderRepository = Mockito.mock(IOrderRepository.class);

		ProductService productService = new ProductService(productRepository, orderRepository);

		Response<Boolean> response = productService.AddProduct("TestProductName", "TestProductDescription", "-99.99");

		assertEquals(false, response.getData());
	}
}
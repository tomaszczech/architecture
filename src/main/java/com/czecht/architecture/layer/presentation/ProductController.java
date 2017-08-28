package com.czecht.architecture.layer.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czecht.architecture.layer.business.ProductService;
import com.czecht.architecture.layer.data.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		if(product == null) {
			throw new IllegalArgumentException("Null object exception");
		}
		productService.addProduct(product);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return productService.findAll();
	}
}

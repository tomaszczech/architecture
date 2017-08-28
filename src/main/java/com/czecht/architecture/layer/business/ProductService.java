package com.czecht.architecture.layer.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.czecht.architecture.ddd.annotations.domain.application.ApplicationService;
import com.czecht.architecture.layer.data.Product;
import com.czecht.architecture.layer.data.ProductRepository;

@ApplicationService
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	@Transactional
	public void addProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

}

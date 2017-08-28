package com.czecht.architecture.layer.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Entity
public class Product {

	@Id
	@GeneratedValue
	private String id;

	private String name;

	private Double price;

}

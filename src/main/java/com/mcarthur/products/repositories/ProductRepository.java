package com.mcarthur.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcarthur.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}

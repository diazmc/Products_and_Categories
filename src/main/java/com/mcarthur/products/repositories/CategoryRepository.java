package com.mcarthur.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcarthur.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}

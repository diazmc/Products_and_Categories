package com.mcarthur.products.controllers;

import javax.validation.Valid;
import com.mcarthur.products.models.*;
import com.mcarthur.products.services.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Products {

	private final ProductService productService;
	private final CategoryService categoryService;
	
	public Products(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct() {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
		public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if(result.hasErrors()) {
				return "newProduct.jsp";
			}
			else {
				productService.addProduct(product);
				return "redirect:/products/new";
			}
		}

	@RequestMapping("/categories/new")
	public String newCategory() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			categoryService.addCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String displayProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findById(id);
		Iterable<Category> categories = categoryService.allCategories();
		
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "displayProduct.jsp";
	}
	
		
	@RequestMapping("/categories/{id}")
	public String displayCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findById(id);
		Iterable<Product> products = productService.allProducts();
		
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "displayCategory.jsp";
	}
	
	@PostMapping("/add/category")
	public String addCat(@RequestParam("category_id") Long cat_id, @RequestParam("product_id") Long prod_id) {
		Product product = productService.findById(prod_id);
		Category category = categoryService.findById(cat_id);
		
		product.getCategories().add(category);
		
		productService.addProduct(product);
		
		return "redirect:/products/" + prod_id ;
	}
	
	@PostMapping("/add/product")
	public String addPro(@RequestParam("category_id") Long cat_id, @RequestParam("product_id") Long prod_id) {
		Product product = productService.findById(prod_id);
		Category category = categoryService.findById(cat_id);
		
		category.getProducts().add(product);
		
		categoryService.addCategory(category);
		
		return "redirect:/categories/" + cat_id ;
	}
	
}



	
	
	
		


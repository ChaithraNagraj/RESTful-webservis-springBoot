package com.bridgelabz.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.exception.ProductNotfoundException;
import com.bridgelabz.demo.model.Product;
/****
 * @ExceptionHandler:is an annotation used to handle the specific exceptions 
 *                   and sending the custom response to the client
 * @ControllerAdvice:class to  handle the exception globally
 * @author admin
 *
 */

@RestController
public class ProductServiceController {
	private static Map<String, Product> productRepo = new HashMap<>();
	   static {
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      productRepo.put(almond.getId(), almond);
	   }
	   
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
	      if(!productRepo.containsKey(id))throw new ProductNotfoundException();
	      productRepo.remove(id);
	      product.setId(id);
	      productRepo.put(id, product);
	      return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	   }
	}


package com.bridgelabz.demo.controller;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.demo.model.Product;
/***
 * @Exchange(): we use exchange method to consume the web services for all Http methods
 * # Autowired the rest template Object
 * # Use HttpHeaders to set the Request object
 * # Use HttpEntity to wrap the request object
 * # Provided the url , HttoMethod and return type for exchange() method
 * @author admin
 *
 */
@RestController
public class ConsumeWebService {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/template/products")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
   }
   @RequestMapping(value = "/template/products", method = RequestMethod.POST)
   public String createProducts(@RequestBody Product product) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
   }
   @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
   public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
   }
   @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
   public String deleteProduct(@PathVariable("id") String id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   }
}
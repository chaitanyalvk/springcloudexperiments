package com.chaitanyalvk.springcloudexperiments.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chaitanyalvk.springcloudexperiments.model.Customer;
import com.chaitanyalvk.springcloudexperiments.services.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService custService) {
		this.customerService = custService;
	}

	@GetMapping({"/{custId}"})
	public ResponseEntity<Customer> getCustomer(@PathVariable("custId")  UUID custId) {
		return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		
		Customer newCustomer = customerService.addCustomer(customer);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", "/api/v1/customer/" + newCustomer.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{customerId}"})
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId")  UUID customerId, @RequestBody Customer customer){
		
		customerService.updateCustomer(customerId, customer);
		
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{customerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteCustomer(customerId);
	}

}

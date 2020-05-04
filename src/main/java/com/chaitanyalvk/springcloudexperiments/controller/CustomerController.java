package com.chaitanyalvk.springcloudexperiments.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

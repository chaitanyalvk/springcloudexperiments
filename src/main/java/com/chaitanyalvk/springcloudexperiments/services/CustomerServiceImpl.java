package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chaitanyalvk.springcloudexperiments.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer getCustomerById(UUID custId) {
		return Customer.builder().id(custId)
				.name("LVKC")
				.gender('M')
				.age(30)
				.build();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return Customer.builder().id(customer.getId())
				.name(customer.getName())
				.gender(customer.getGender())
				.age(customer.getAge())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		log.debug("Deleted Customer by id - " + customerId);
		
	}
}

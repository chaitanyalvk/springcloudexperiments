package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chaitanyalvk.springcloudexperiments.model.Customer;

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
}

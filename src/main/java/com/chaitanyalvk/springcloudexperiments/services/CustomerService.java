package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import com.chaitanyalvk.springcloudexperiments.model.Customer;

public interface CustomerService {

	Customer getCustomerById(UUID custId);


}

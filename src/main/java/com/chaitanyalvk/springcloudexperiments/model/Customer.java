package com.chaitanyalvk.springcloudexperiments.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	
	private UUID id;
	private String name;
	private char gender;
	private int age;

}

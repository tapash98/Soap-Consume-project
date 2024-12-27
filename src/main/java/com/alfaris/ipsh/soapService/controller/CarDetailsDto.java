package com.alfaris.ipsh.soapService.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CarDetailsDto {

	
	private  String carName;

	private double price;
	
	private String status;
	
	private String createdBy;

	
}

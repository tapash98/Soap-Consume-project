package com.alfaris.ipsh.soapService.controller;

import java.util.List;

import org.json.simple.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceResponse {

	private String code;
	private String message;
	private List<JSONObject> details;

	

}

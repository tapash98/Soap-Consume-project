package com.alfaris.ipsh.soapService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.alfaris.ipsh.consumessoapservice.AddEmployeeRequest;
import com.alfaris.ipsh.consumessoapservice.AddEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.DeleteEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.GetAllEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.GetEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.SearchEmployeeResponse;
import com.alfaris.ipsh.soapService.client.SoapClient;


@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/get")
	public GetEmployeeResponse getEmployeeById(@RequestParam long id )throws SoapFaultClientException {
		return client.getEmployee(id);
		
	} 
	
	@GetMapping("/getAll")
	public GetAllEmployeeResponse getAllEmployee() {
		return client.getAllEmployee();
	}
	
	@PostMapping("/add")
	public AddEmployeeResponse addEmployee(@RequestBody AddEmployeeRequest request) {
		return client.addEmployee(request);
	} 
	
	@PostMapping("/delete")
	public DeleteEmployeeResponse deleteById(@RequestParam long id) {
		return client.deleteByid(id);
	}
	
	@GetMapping("/search")
	
	public SearchEmployeeResponse searchEmployee(@RequestParam String searchParam,@RequestParam String iDisplayStart,@RequestParam String iDisplayLength
			) {
		return client.search(searchParam,iDisplayStart,iDisplayLength);
		
	}
	
	@GetMapping("/tapas")
//	@Scheduled(fixedRate   = 2000)
//	@Scheduled(cron = "0 32 18 * * *")
	public String print() {
		return  client.print();
	}
	
	
	

	
	

}

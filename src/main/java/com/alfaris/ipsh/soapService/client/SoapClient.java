package com.alfaris.ipsh.soapService.client;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import com.alfaris.ipsh.consumessoapservice.AddEmployeeRequest;
import com.alfaris.ipsh.consumessoapservice.AddEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.DeleteEmployeeRequest;
import com.alfaris.ipsh.consumessoapservice.DeleteEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.GetAllEmployeeRequest;
import com.alfaris.ipsh.consumessoapservice.GetAllEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.GetEmployeeByIdRequest;
import com.alfaris.ipsh.consumessoapservice.GetEmployeeResponse;
import com.alfaris.ipsh.consumessoapservice.SearchEmployeeRequest;
import com.alfaris.ipsh.consumessoapservice.SearchEmployeeResponse;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	private static final String SOAP_URL = "http://localhost:1010/allService";

	public GetEmployeeResponse getEmployee(long id)throws SoapFaultClientException {
		try {
			template = new WebServiceTemplate(marshaller);
			GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
			request.setEmployeeId(id);
			return (GetEmployeeResponse) template.marshalSendAndReceive(SOAP_URL, request);
		} catch (SoapFaultClientException e) {
			log.error(" Soap Exception",e.getMessage());
			throw e; 
		}catch(Exception e) {
			log.error("Exception ",e.getMessage(),e);
		}
		return null;
 
	}

	public GetAllEmployeeResponse getAllEmployee() {
		template = new WebServiceTemplate(marshaller);
		GetAllEmployeeRequest request = new GetAllEmployeeRequest();
		return (GetAllEmployeeResponse) template.marshalSendAndReceive(SOAP_URL, request);
	}

	public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (AddEmployeeResponse) template.marshalSendAndReceive(SOAP_URL, request);
	}

	public DeleteEmployeeResponse deleteByid(long id) {
		DeleteEmployeeRequest request = new DeleteEmployeeRequest();
		request.setEmployeeId(id);
		template = new WebServiceTemplate(marshaller);
		return (DeleteEmployeeResponse) template.marshalSendAndReceive(SOAP_URL, request);
	}

	public String print() {
		System.out.println(LocalDateTime.now()+"  Tapas Kumar Behera ");
		return "tapas";
	}

	public SearchEmployeeResponse search(String searchParam, String iDisplayStart, String iDisplayLength) {
		SearchEmployeeRequest request = new SearchEmployeeRequest();
		int iDisplayStart1 = Integer.parseInt(iDisplayStart);
		int iDisplayLength1 = Integer.parseInt(iDisplayLength);
		request.setSearchParam(searchParam);
		request.setIDisplayStart(iDisplayStart1);
		request.setIDisplayLength(iDisplayLength1); 
		template = new WebServiceTemplate(marshaller);
		return (SearchEmployeeResponse) template.marshalSendAndReceive(SOAP_URL,request);
	}

	
	 

}

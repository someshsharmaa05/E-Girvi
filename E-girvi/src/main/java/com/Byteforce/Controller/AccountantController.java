package com.Byteforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Byteforce.DTO.Accountant;
import com.Byteforce.DTO.Propritor;
import com.Byteforce.Responce.ResponseStructure;
import com.Byteforce.Service.AccountantService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AccountantController {

	@Autowired
	AccountantService service ;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value = "/saveAccountant")
	public ResponseStructure<Accountant> saveAccouuntantController(@RequestBody Accountant accountant){
		return service.saveAccountantService(accountant);
	}
	
	@PostMapping(value = "/updateAccountant")
	public ResponseStructure<Accountant> updateFirmController(@RequestBody Accountant accountant){
		return service.updateAccountantService(accountant);
	}
	
	@PostMapping(value = "/loginPropritor/{id}/{password}")
	public ResponseStructure<Accountant> loginAccountantController(@PathVariable String email ,@PathVariable String password){
		ResponseStructure<Accountant> structure =  service.loginAccountantService(email,password);
		if (structure.getData() != null) {
			session.setAttribute("accountant", structure.getData());
		} 
		return structure;
	}	
}

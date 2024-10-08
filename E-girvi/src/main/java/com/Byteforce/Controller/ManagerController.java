package com.Byteforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Byteforce.DTO.Manager;
import com.Byteforce.Responce.ResponseStructure;
import com.Byteforce.Service.ManagerService;

import jakarta.servlet.http.HttpSession;

public class ManagerController {

	@Autowired
	ManagerService service ;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value = "/saveManager")
	public ResponseStructure<Manager> saveManagerController(@RequestBody Manager manager){
		return service.saveManagerService(manager);
	}
	
	@PostMapping(value = "/updateManager")
	public ResponseStructure<Manager> updateManagerController(@RequestBody Manager manager){
		return service.updateManagerService(manager);
	}
	
	@PostMapping(value = "/loginManager/{id}/{password}")
	public ResponseStructure<Manager> loginManagerController(@PathVariable String email ,@PathVariable String password){
		ResponseStructure<Manager> structure =  service.loginManagerService(email, password);
		if (structure.getData() != null) {
			session.setAttribute("manager", structure.getData());
		} 
		return structure;
	}	
}

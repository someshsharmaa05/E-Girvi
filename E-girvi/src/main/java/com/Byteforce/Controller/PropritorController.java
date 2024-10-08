package com.Byteforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Byteforce.DTO.Propritor;
import com.Byteforce.Responce.ResponseStructure;
import com.Byteforce.Service.PropritorService;

import jakarta.servlet.http.HttpSession;

@RestController
public class PropritorController {
	
	@Autowired
	PropritorService service;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value = "/savePropritor")
	public ResponseStructure<Propritor> savePropritorController(@RequestBody Propritor propritor){
		return service.savePropritorService(propritor);
	}
	
	@PostMapping(value = "/loginPropritor/{id}/{password}")
	public ResponseStructure<Propritor> loginPropritorController(@PathVariable int id ,@PathVariable String password){
		ResponseStructure<Propritor> structure =  service.loginPropritorService(id,password);
		if (structure.getData() != null) {
			session.setAttribute("propritor", structure.getData());
		} 
		return structure;
	}	
}

package com.Byteforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Byteforce.DTO.Firm;
import com.Byteforce.Responce.ResponseStructure;
import com.Byteforce.Service.FirmService;

import jakarta.servlet.http.HttpSession;

@RestController
public class FirmController {

	@Autowired
	HttpSession session;
	
	@Autowired
	FirmService service;
	
	@PostMapping(value = "/saveFirm")
	public ResponseStructure<Firm> saveFirmController(@RequestBody Firm firm){
		return service.saveFirmService(firm);
	}
	
	@GetMapping(value = "/FetchFirm/{name}")
	public ResponseStructure<Firm> fetchFirmController(@PathVariable String name){
		return service.findFirmService(name);
	}
	
	@PostMapping(value = "/updateFirm")
	public ResponseStructure<Firm> updateFirmController(@RequestBody Firm firm){
		return service.updateFirmService(firm);
	}
}

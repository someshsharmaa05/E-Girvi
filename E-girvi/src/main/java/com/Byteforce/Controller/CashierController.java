package com.Byteforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Byteforce.DTO.Cashier;
import com.Byteforce.Responce.ResponseStructure;
import com.Byteforce.Service.CashierService;
import jakarta.servlet.http.HttpSession;

@RestController
public class CashierController {
	
	@Autowired
	CashierService service ;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value = "/saveCashier")
	public ResponseStructure<Cashier> saveCashierController(@RequestBody Cashier cashier){
		return service.saveCashierService(cashier);
	}
	
	@PostMapping(value = "/updateCashier")
	public ResponseStructure<Cashier> updateCashierController(@RequestBody Cashier cashier){
		return service.updateCashierService(cashier);
	}
	
	@PostMapping(value = "/loginCashier/{id}/{password}")
	public ResponseStructure<Cashier> loginCashierController(@PathVariable String email ,@PathVariable String password){
		ResponseStructure<Cashier> structure =  service.loginCashierService(email, password);
		if (structure.getData() != null) {
			session.setAttribute("cashier", structure.getData());
		} 
		return structure;
	}	
}

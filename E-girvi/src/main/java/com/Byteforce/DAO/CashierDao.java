package com.Byteforce.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Byteforce.DTO.Cashier;
import com.Byteforce.Repositry.CashierRepositry;

@Repository
public class CashierDao {

	@Autowired
	CashierRepositry repositry;
	
	public Cashier saveCashierDao(Cashier cashier) {
		return repositry.save(cashier);
	}
	
	public Cashier findById(int id) {
		return repositry.findById(id).get();
	}
	
	public List<Cashier> findCashierByEmailDao(String email) {
		return repositry.findByEmail(email);
	}
}

package com.Byteforce.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Byteforce.DTO.Accountant;
import com.Byteforce.DTO.Firm;
import com.Byteforce.Repositry.AccountantRepositry;

@Repository
public class AccountantDao {
	
	@Autowired
	AccountantRepositry repositry;
	
	public Accountant saveAccountantDao(Accountant accountant) {
		return repositry.save(accountant);
	}
	
	public Accountant findById(int id) {
		return repositry.findById(id).get();
	}
	
	public List<Accountant> findAccountantByEmailDao(String email) {
		return repositry.findByEmail(email);
	}
}

package com.Byteforce.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Byteforce.DTO.Manager;
import com.Byteforce.Repositry.ManagerRepositry;

@Repository
public class ManagerDao {
	
	@Autowired
	ManagerRepositry repositry;
	
	public Manager saveManagerDao(Manager manager) {
		return repositry.save(manager);
	}
	
	public Manager findById(int id) {
		return repositry.findById(id).get();
	}
	
	public List<Manager> findManagerByEmailDao(String email) {
		return repositry.findByEmail(email);
	}
}

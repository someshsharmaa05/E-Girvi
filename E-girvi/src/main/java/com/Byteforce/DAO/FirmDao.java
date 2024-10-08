package com.Byteforce.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Byteforce.DTO.Firm;
import com.Byteforce.Repositry.FirmRepositry;

@Repository
public class FirmDao {
	
	@Autowired
	FirmRepositry repositry;
	
	// Save the firm
	
	public Firm saveFirmDao(Firm firm) {
		return repositry.save(firm);
	}
	
	// To fetch the Firm by Firm Name
	
	public Firm findByName(String name) {
		Optional<Firm> optional = repositry.findById(name);
		if (optional != null) {
			return optional.get();
		} else {
			return null;
		}
		
	}
}

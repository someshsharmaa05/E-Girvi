package com.Byteforce.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Byteforce.DTO.Propritor;
import com.Byteforce.Repositry.PropriterRepositry;

@Repository
public class PropritorDao {
	
	@Autowired
	PropriterRepositry repositry;
	
	public Propritor savePropritor(Propritor propritor) {
		return repositry.save(propritor);
	}
	
	public Propritor getPropritor(int id) {
		return repositry.findById(id).get();
	}
	
	public List<Propritor> getAllPropritor() {
		return repositry.findAll();
	}
}

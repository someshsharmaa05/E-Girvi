package com.Byteforce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Byteforce.DAO.PropritorDao;
import com.Byteforce.DTO.Propritor;
import com.Byteforce.Repositry.PropriterRepositry;
import com.Byteforce.Responce.ResponseStructure;

@Service
public class PropritorService {
	
	@Autowired
	ResponseStructure<Propritor>  structure;
	
	@Autowired
	PropritorDao dao;
	
	public ResponseStructure<Propritor> savePropritorService(Propritor propritor){
		Propritor admin2 =  dao.savePropritor(propritor);
		
		if (admin2 != null) {
			structure.setStatus(HttpStatus.ACCEPTED.value());
			structure.setMsg("Admin created succesfully !!");
		} else {
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			structure.setMsg("Admin not created !!");
		}
		structure.setData(admin2);
		return structure;
	}
	
	public ResponseStructure<Propritor> getPropritorService(int id) {
		Propritor admin =  dao.getPropritor(id);
		if (admin != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMsg("Admin found succesfully !!");
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("Admin not found succesfully !!");
		}
		structure.setData(admin);
		return structure;
	}
	
	public ResponseStructure<Propritor> loginPropritorService(int id, String password) {
		Propritor admin =  dao.getPropritor(id);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setMsg("Propritor login succesfully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Propritor login Failed wrong Password !!");
				structure.setData(null);
				return structure;
			}
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("Propritor not found wrong Id !!");
		}
		structure.setData(admin);
		return structure;
	}
}

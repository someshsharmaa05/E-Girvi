package com.Byteforce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Byteforce.DAO.AccountantDao;
import com.Byteforce.DTO.Accountant;
import com.Byteforce.DTO.Firm;
import com.Byteforce.DTO.Propritor;
import com.Byteforce.Responce.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class AccountantService {
	
	@Autowired
	AccountantDao dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ResponseStructure<Accountant> structure;
	
	public ResponseStructure<Accountant> saveAccountantService(Accountant accountant) {
		if (session.getAttribute("propritor") != null) {
			Accountant accountant2 = dao.saveAccountantDao(accountant);
			if (accountant2 != null) {
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("Accountant saved Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Accountant not saved Succefully !!");
			}
			structure.setData(accountant2);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure; 
	}
	
	public ResponseStructure<Accountant> findAccountantByIdService(int id) {
		if (session.getAttribute("propritor") != null) {
			Accountant accountant = dao.findById(id);
			if (accountant != null) {
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMsg("Accountant found Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMsg("Accountant not saved Succefully !!");
			}
			structure.setData(accountant);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Accountant> updateAccountantService(Accountant accountant) {

		if (session.getAttribute("propritor") != null) {
			if (accountant != null) {
				Accountant accountant2 = findAccountantByIdService(accountant.getId()).getData();
				if (accountant2 != null) {
					dao.saveAccountantDao(accountant);
					structure.setStatus(HttpStatus.OK.value());
					structure.setMsg("Accountant update Succefully !!");
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("This Accountant not exists !!");
				}
				structure.setData(accountant);
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Null Accountant can't not update !!");
				structure.setData(null);
			}
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Accountant> loginAccountantService(String email, String password) {
		List<Accountant> accountants =  dao.findAccountantByEmailDao(email);
		if (!accountants.isEmpty()) {
			for (Accountant accountant : accountants) {
				if (accountant.getPassword().equals(password) && accountant.getEmail().equals(email)) {
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setMsg("Accountant login succesfully !!");
					structure.setData(accountant);
					return structure;
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("Accountant login Failed wrong Password !!");
				}
				structure.setData(accountant);
				return structure;
			}
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("Accountant not found wrong Id !!");
		}
		structure.setData(null);
		return structure;
	}
}

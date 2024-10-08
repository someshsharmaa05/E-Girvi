package com.Byteforce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Byteforce.DAO.FirmDao;
import com.Byteforce.DTO.Firm;
import com.Byteforce.Responce.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class FirmService {

	@Autowired
	FirmDao dao;

	@Autowired
	ResponseStructure<Firm> structure;

	@Autowired
	HttpSession session;

	// To Save the Firm 
	
	public ResponseStructure<Firm> saveFirmService(Firm firm) {

		if (session.getAttribute("propritor") != null) {
			Firm firm2 = dao.saveFirmDao(firm);
			if (firm2 != null) {
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("Firm saved Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Firm not saved Succefully !!");
			}
			structure.setData(firm2);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}

	// To fetch the Firm by Firm Name
	
	public ResponseStructure<Firm> findFirmService(String name) {
		if (session.getAttribute("propritor") != null) {
			Firm firm = dao.findByName(name);
			if (firm != null) {
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMsg("Firm found Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMsg("Firm not saved Succefully !!");
			}
			structure.setData(firm);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	// To update the Firm if such firm is avilabile which has the same name as the given firm
	
	public ResponseStructure<Firm> updateFirmService(Firm firm) {

		if (session.getAttribute("propritor") != null) {
			if (firm != null) {
				Firm firm2 = findFirmService(firm.getName()).getData();
				if (firm2 != null) {
					dao.saveFirmDao(firm);
					structure.setStatus(HttpStatus.OK.value());
					structure.setMsg("Firm update Succefully !!");
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("This firm not exists !!");
				}
				structure.setData(firm2);
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Null firm can't not update !!");
				structure.setData(null);
			}
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	
}

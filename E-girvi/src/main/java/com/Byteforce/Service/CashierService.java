package com.Byteforce.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.Byteforce.DAO.CashierDao;
import com.Byteforce.DTO.Cashier;
import com.Byteforce.Responce.ResponseStructure;
import jakarta.servlet.http.HttpSession;

@Service
public class CashierService {

	@Autowired
	CashierDao dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ResponseStructure<Cashier> structure;
	
	public ResponseStructure<Cashier> saveCashierService(Cashier cashier) {
		if (session.getAttribute("propritor") != null) {
			Cashier cashier2 = dao.saveCashierDao(cashier);
			if (cashier2 != null) {
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("Cashier saved Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Cashier not saved Succefully !!");
			}
			structure.setData(cashier2);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure; 
	}
	
	public ResponseStructure<Cashier> findCashierByIdService(int id) {
		if (session.getAttribute("propritor") != null) {
			Cashier cashier = dao.findById(id);
			if (cashier != null) {
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMsg("Cashier found Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMsg("Cashier not saved Succefully !!");
			}
			structure.setData(cashier);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Cashier> updateCashierService(Cashier cashier) {

		if (session.getAttribute("propritor") != null) {
			if (cashier != null) {
				Cashier cashier2 = findCashierByIdService(cashier.getId()).getData();
				if (cashier2 != null) {
					dao.saveCashierDao(cashier);
					structure.setStatus(HttpStatus.OK.value());
					structure.setMsg("Cashier update Succefully !!");
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("This Cashier not exists !!");
				}
				structure.setData(cashier);
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Null Cashier can't not update !!");
				structure.setData(null);
			}
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Cashier> loginCashierService(String email, String password) {
		List<Cashier> cashiers =  dao.findCashierByEmailDao(email);
		if (!cashiers.isEmpty()) {
			for (Cashier cashier : cashiers) {
				if (cashier.getPassword().equals(password) && cashier.getEmail().equals(email)) {
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setMsg("Cashier login succesfully !!");
					structure.setData(cashier);
					return structure;
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("Propritor login Failed wrong Password !!");
				}
				structure.setData(cashier);
				return structure;
			}
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("Cashier not found wrong Id !!");
		}
		structure.setData(null);
		return structure;
	}
}

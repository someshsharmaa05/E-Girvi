package com.Byteforce.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.Byteforce.DAO.ManagerDao;
import com.Byteforce.DTO.Manager;
import com.Byteforce.Responce.ResponseStructure;
import jakarta.servlet.http.HttpSession;

@Service
public class ManagerService {

	@Autowired
	ManagerDao dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ResponseStructure<Manager> structure;
	
	public ResponseStructure<Manager> saveManagerService(Manager manager) {
		if (session.getAttribute("propritor") != null) {
			Manager manager2 = dao.saveManagerDao(manager);
			if (manager2 != null) {
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("Manager saved Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Manager not saved Succefully !!");
			}
			structure.setData(manager2);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure; 
	}
	
	public ResponseStructure<Manager> findManagerByIdService(int id) {
		if (session.getAttribute("propritor") != null) {
			Manager manager = dao.findById(id);
			if (manager != null) {
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMsg("Manager found Succefully !!");
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMsg("Manager not saved Succefully !!");
			}
			structure.setData(manager);
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Manager> updateManagerService(Manager manager) {

		if (session.getAttribute("propritor") != null) {
			if (manager != null) {
				Manager manager2 = findManagerByIdService(manager.getId()).getData();
				if (manager2 != null) {
					dao.saveManagerDao(manager);
					structure.setStatus(HttpStatus.OK.value());
					structure.setMsg("Manager update Succefully !!");
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("This Manager not exists !!");
				}
				structure.setData(manager);
			} else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Null Manager can't not update !!");
				structure.setData(null);
			}
		} else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMsg("Propritor not login,  login first !!");
			structure.setData(null);
		}
		return structure;
	}
	
	public ResponseStructure<Manager> loginManagerService(String email, String password) {
		List<Manager> managers =  dao.findManagerByEmailDao(email);
		if (!managers.isEmpty()) {
			for (Manager manager : managers) {
				if (manager.getPassword().equals(password) && manager.getEmail().equals(email)) {
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setMsg("Manager login succesfully !!");
					structure.setData(manager);
					return structure;
				} else {
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					structure.setMsg("Manager login Failed wrong Password !!");
				}
				structure.setData(manager);
				return structure;
			}
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("Manager not found wrong Id !!");
		}
		structure.setData(null);
		return structure;
	}
}

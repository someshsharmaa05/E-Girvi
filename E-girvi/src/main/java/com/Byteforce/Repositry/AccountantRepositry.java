package com.Byteforce.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Byteforce.DTO.Accountant;
import java.util.List;


public interface AccountantRepositry extends JpaRepository<Accountant, Integer>{

	public List<Accountant> findByEmail(String email);
}

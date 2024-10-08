package com.Byteforce.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Byteforce.DTO.Manager;

public interface ManagerRepositry extends JpaRepository<Manager, Integer>{

	public List<Manager> findByEmail(String email);
}

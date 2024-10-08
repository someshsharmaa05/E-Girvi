package com.Byteforce.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Byteforce.DTO.Cashier;

public interface CashierRepositry extends JpaRepository<Cashier, Integer>{

	public List<Cashier> findByEmail(String email);
}

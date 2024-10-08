package com.Byteforce.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Accountant {

	@Id
	//@Value(Math.random()*1000)
	private int id;
	private String name;
	private String fathername;
	private String email;
	private long mobileno;
	private String password;
	private long aaharnumber;
	private String PAN;
	private String address;
	private String nomination;
	private double salary;
	@OneToOne
	private Account account;
	private Object image;
	
	public Accountant(String name, String fathername, String email, long mobileno, String password,
			long aaharnumber, String pAN, String address, String nomination, double salary, Account account,
			Object image) {
		super();
		this.id = (int) (Math.random()*1000);
		this.name = name;
		this.fathername = fathername;
		this.email = email;
		this.mobileno = mobileno;
		this.password = password;
		this.aaharnumber = aaharnumber;
		PAN = pAN;
		this.address = address;
		this.nomination = nomination;
		this.salary = salary;
		this.account = account;
		this.image = image;
	}
	
	
}

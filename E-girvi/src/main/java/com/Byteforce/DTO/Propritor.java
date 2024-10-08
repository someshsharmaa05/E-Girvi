package com.Byteforce.DTO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OrderBy;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Propritor {
	private static Propritor propritor;
	
	@Id
	private int id;
	private String name;
	private String fatherName;
	private LocalDate dob;
	private long phoneNo;
	private long alterPhoneNo;
	private long WhPhoneNo;
	private String email;
	private String password;
	private long adharNumber;
	private String PAN;
	private String DLNumber;
	private String nomineName;
	@OneToOne(mappedBy = "propritor")
	private Firm firm;
	@OneToMany
	private List<Account> accounts;
	private Object adminImage;
	
	
	
	
	public static Propritor getInstanceOfAdmin(String name,String fatherName, LocalDate dob,long phoneNo, long alterphoneNo, long WhphoneNo, String email, String password, long adharNumber, String PAN, String dlNumber, String nomineName, List<Account> accounts, Object adminImage ) {
		if(propritor == null) {
			return new Propritor(name, fatherName, dob, phoneNo, alterphoneNo, WhphoneNo, email, password, adharNumber, PAN, dlNumber, nomineName, accounts, adminImage);
		}
		return propritor;
	}




	public Propritor(String name, String fatherName, LocalDate dob, long phoneNo, long alterPhoneNo,
			long whPhoneNo, String email, String password, long adharNumber, String pAN, String dLNumber,
			String nomineName, List<Account> accounts, Object adminImage) {
		super();
		this.id = (int)(Math.random()*1000);
		this.name = name;
		this.fatherName = fatherName;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.alterPhoneNo = alterPhoneNo;
		WhPhoneNo = whPhoneNo;
		this.email = email;
		this.password = password;
		this.adharNumber = adharNumber;
		PAN = pAN;
		DLNumber = dLNumber;
		this.nomineName = nomineName;
		this.accounts = accounts;
		this.adminImage = adminImage;
	}


}

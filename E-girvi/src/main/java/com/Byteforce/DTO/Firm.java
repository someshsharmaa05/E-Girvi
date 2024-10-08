package com.Byteforce.DTO;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Firm {
	@Id
	private String name;
	private String GSTNo;
	private String address;
	@OneToOne
	private Propritor propritor;
	private String nomine;
	private String email;
	private long phoneno;
	private long mobileno;
	private long additionalno;
	@OneToMany
	private List<Account> accounts;
	@OneToMany
	private List<Accountant> accountants;
	@OneToMany
	private List<Cashier> cashiers;
	@OneToOne
	private Manager manager;
}

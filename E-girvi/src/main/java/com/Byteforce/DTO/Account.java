package com.Byteforce.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	private String branchIFSC;
	private String branchName;
	private long accountNumber;
	private String accountType;
	@ManyToOne
	private Bank bank;
}

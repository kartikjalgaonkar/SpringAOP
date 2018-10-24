package com.training.service;

import org.springframework.stereotype.Service;

@Service
public class TransferService {
	public void transfer(String accountA, String accountB, Long amount){
		System.out.println("amount is "+amount);
	}
	
	public Double checkBalance(String account){
		System.out.println("available balance is 5000");
		return new Double(5000);
	}
	
	public Long withdrawl(String account, Long amount){
		System.out.println("withdrawl amount is "+amount);
		return amount;
	}
}

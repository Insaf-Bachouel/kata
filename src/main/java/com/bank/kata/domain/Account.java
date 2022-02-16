package com.bank.kata.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bank.kata.constant.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Account {
	private float balance ; 
	private List<Transaction> transactions ; 
	
	public Account() {
		this.balance=0L ;
		this.transactions=new ArrayList<>();	
	}
	
	public Account(Float balance) {
		this.balance=balance ;
		this.transactions=new ArrayList<>();	
	}
	public void deposit(float amount)  {
			this.balance+= amount ; 
			saveTransaction(TransactionType.DEPOSIT, amount, this.balance);	
	}
	public void withdrawal(float amount) {
			this.balance-= amount ; 
			saveTransaction(TransactionType.WITHDRAWAL, amount,this.balance);
		
	}
	public void saveTransaction(String type , float amount, float balance){
		Transaction transaction = new Transaction(type, LocalDateTime.now(), amount, balance);
		this.transactions.add(transaction) ; 
	}
	

}

package com.bank.kata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.kata.domain.Account;
import com.bank.kata.domain.Transaction;
import com.bank.kata.exception.InvalidAmountException;
import com.bank.kata.exception.NotEnoughFundsException;

@Service
public class AccountService {
	 
	 private static Account account = new Account(1500F) ;
	  
	 
	 public Account makeDeposit(float amount) {
		 CheckAmountValid(amount);
		 account.deposit(amount);
		 return account ; 
	 }
	 
	 public Account makeWithdrawal(float amount) {
		 CheckAmountValid(amount);
		 CheckEnoughFunds(amount,account.getBalance()) ; 
		 account.withdrawal(amount);
		 return account ;
	 }
	 
	 public List<Transaction> getTransactionHistory(){
		 return account.getTransactions() ; 
	 }
	 
	 private void CheckAmountValid(float amount) {
		 if(amount<=0) 
			 throw new InvalidAmountException() ; 
	 }
	 
	 private void CheckEnoughFunds(float amount, float balance) {
		 if(balance<amount) 
			 throw new NotEnoughFundsException() ; 
	 }

}

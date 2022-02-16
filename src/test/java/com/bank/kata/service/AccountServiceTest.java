package com.bank.kata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.kata.domain.Account;
import com.bank.kata.exception.InvalidAmountException;
import com.bank.kata.exception.NotEnoughFundsException;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	@InjectMocks
	public AccountService accountService = new AccountService() ; 
	 
	@Test
	public void shouldMakeDeposit() {
		
		Account account = accountService.makeDeposit(50.5F) ; 
		assertEquals(1550.5F, account.getBalance());
		assertEquals(1, account.getTransactions().size());
	}
	
	@Test
	public void shouldThrowInvalidAmountExceptionWhenMakingDeposit() {
	assertThrows(InvalidAmountException.class, ()->accountService.makeDeposit(-50.5F)); 
		
	}
	
	@Test
	public void shouldMakeWithdrawal() {
		Account account = accountService.makeWithdrawal(20F) ; 
		assertEquals(1480F, account.getBalance());
		assertEquals(1, account.getTransactions().size());
	}
	
	@Test
	public void shouldThrowInvalidAmountExceptionWhenMakeWithdrawal() {
	assertThrows(InvalidAmountException.class, ()->accountService.makeWithdrawal(-50.5F)); 
		
	}
	@Test
	public void shouldThrowNotEnoughFundsExceptionWhenMakeWithdrawal() {
	assertThrows(NotEnoughFundsException.class, ()->accountService.makeWithdrawal(5000)); 
		
	}
	

}

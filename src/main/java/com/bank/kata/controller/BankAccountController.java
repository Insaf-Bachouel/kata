package com.bank.kata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.kata.domain.Account;
import com.bank.kata.domain.Transaction;
import com.bank.kata.dto.Amount;
import com.bank.kata.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
	
	@Autowired
	AccountService accountService;
	 
	 @Operation(summary ="make deposit in my account")
	 @PostMapping(value = "/deposit")
	  public Account makeDeposit(@RequestBody Amount amount) {
	    return accountService.makeDeposit(amount.getValue()) ;
	  }
	 @Operation(summary ="make withdrawal of  my account")
	 @PostMapping(value = "/withdrawal")
	  public Account makeWithdrawal(@RequestBody Amount amount) {
	    return accountService.makeWithdrawal(amount.getValue()) ;
	  }
	 @Operation(summary ="get my account history")
	 @GetMapping(value = "/history")
	  public List<Transaction> getHistory() {
	    return accountService.getTransactionHistory() ;
	  }
	 

}

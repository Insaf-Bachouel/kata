package com.bank.kata.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bank.kata.dto.Amount;
import com.bank.kata.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = BankAccountController.class) 
public class BankAccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountService accountService;
	
	@Test
	void shouldMakeDeposit() throws Exception{
		Amount amount = new Amount(50F);
		mockMvc.perform(MockMvcRequestBuilders
				.post("/accounts/deposit")
				.contentType(MediaType.APPLICATION_JSON).content(asJson(amount))
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()) ;
		
	}
	@Test
	void shouldMakeWithdrawal() throws Exception{
		Amount amount = new Amount(50F);
		mockMvc.perform(MockMvcRequestBuilders
				.post("/accounts/withdrawal")
				.contentType(MediaType.APPLICATION_JSON).content(asJson(amount))
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()) ;
		
	}
	
	@DisplayName("Get operations history")
	@Test
	void shouldDisplayTransactionsHistory() throws Exception {

		mockMvc.perform(get("/accounts/history")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	static String asJson(Object obj) {
		try {
			return new ObjectMapper().findAndRegisterModules().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

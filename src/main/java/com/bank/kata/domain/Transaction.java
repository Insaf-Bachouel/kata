package com.bank.kata.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {
	private String operation ; 
	private LocalDateTime date ; 
	private float amount ; 
	private float balance ; 
	
	

}

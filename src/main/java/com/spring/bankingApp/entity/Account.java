package com.spring.bankingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long account_number;
    private String account_name;
    private Double balance;
     
    public Account() {
    	
    }

	public Account(String account_name, Double balance) {
		super();
		this.account_name = account_name;
		this.balance = balance;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_name=" + account_name + ", balance=" + balance
				+ "]";
	}
    
}

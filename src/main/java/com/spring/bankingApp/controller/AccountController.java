package com.spring.bankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bankingApp.entity.Account;
import com.spring.bankingApp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired 
	AccountService service;
	  //create an account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount=service.createAccount(account);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	@GetMapping("/{accountNumber}")
	public Account getAccountDetailsByAccountNumber(@PathVariable Long accountNumber) {
		Account account = service.getAccountDetailsByAccountNumber(accountNumber);
		return account;
	}
	 @GetMapping("/getallaccounts")
	 public List<Account> getAllAccountDetails() {
		 List<Account> getallaccounts = service.getAllAccountDetails();
		 return getallaccounts;
	 }
	 @PutMapping("/deposite/{accountNumber}/{amount}")
		 public Account depositeMoney(@PathVariable Long accountNumber,@PathVariable Double amount) {
		   Account account = service.depositeMoney(accountNumber, amount);
		   return account;
	 }
	 @PutMapping("/withdrawl/{accountNumber}/{amount}")
	 public Account withdrawlAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		 Account account = service.withdrawlAmount(accountNumber, amount);
		    return account;
	 }
	  @DeleteMapping("delete/{accountNumber}")
	  public ResponseEntity<String> deletedAccount(@PathVariable Long accountNumber){
	     service.closeAccount(accountNumber);
	   return ResponseEntity.ok("account deleted");
	  }

}

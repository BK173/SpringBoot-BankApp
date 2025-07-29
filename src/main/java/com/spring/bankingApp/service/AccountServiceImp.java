package com.spring.bankingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bankingApp.entity.Account;
import com.spring.bankingApp.repo.AccountRepository;
@Service
public class AccountServiceImp implements AccountService {
      
	@Autowired
	AccountRepository repo;
	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccounts = repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account withdrawlAmount(long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account accountPresent = account.get();
		Double totalAmount = accountPresent.getBalance()-amount;
		accountPresent.setBalance(totalAmount);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		

	}

	@Override
	public Account depositeMoney(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		 if(account.isEmpty()) {
			 throw new RuntimeException("Account is not Present bhaiii");
		 }
		 Account accountPresent = account.get();
		 Double totalAmount = accountPresent.getBalance()+amount;
		 accountPresent.setBalance(totalAmount);
		 repo.save(accountPresent);
		return accountPresent;
	}
	

}

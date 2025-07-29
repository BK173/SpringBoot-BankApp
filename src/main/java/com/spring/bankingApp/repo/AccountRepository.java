package com.spring.bankingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	  

}

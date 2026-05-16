package com.nsdev.walletapp.repository;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsdev.walletapp.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, UUID>{
	
	int depositBalance(UUID walletId, BigDecimal amount);
	
	int withdrawBalance(UUID walletId, BigDecimal amount);
}

package com.nsdev.walletapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsdev.walletapp.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, UUID>{

}

package com.nsdev.walletapp.repository;

import com.nsdev.walletapp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Wallet w SET w.balance = w.balance + :amount WHERE w.id = :walletId")
    int depositBalance(@Param("walletId") UUID walletId, @Param("amount") BigDecimal amount);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Wallet w SET w.balance = w.balance - :amount WHERE w.id = :walletId AND w.balance >= :amount")
    int withdrawBalance(@Param("walletId") UUID walletId, @Param("amount") BigDecimal amount);
}
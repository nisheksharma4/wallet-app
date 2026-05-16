package com.nsdev.walletapp.service;


import com.nsdev.walletapp.dto.WalletRequest;
import com.nsdev.walletapp.dto.WalletResponse;
import com.nsdev.walletapp.entity.OperationType;
import com.nsdev.walletapp.entity.Wallet;
import com.nsdev.walletapp.exception.InsufficientFundsException;
import com.nsdev.walletapp.exception.WalletNotFoundException;
import com.nsdev.walletapp.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public WalletResponse processOperation(WalletRequest request) {
        UUID walletId = request.getWalletId();
        BigDecimal amount = request.getAmount();
        OperationType type = request.getOperationType();

        boolean walletExists = walletRepository.existsById(walletId);
        if (!walletExists) {
            throw new WalletNotFoundException("Wallet with ID " + walletId + " does not exist.");
        }

        int rowsAffected = 0;

        if (type == OperationType.DEPOSIT) {
            rowsAffected = walletRepository.depositBalance(walletId, amount);
        } else if (type == OperationType.WITHDRAW) {
            rowsAffected = walletRepository.withdrawBalance(walletId, amount);
            
            if (rowsAffected == 0) {
                throw new InsufficientFundsException("Insufficient funds to complete withdrawal.");
            }
        }

        return getWalletBalance(walletId);
    }

    @Transactional
    public WalletResponse getWalletBalance(UUID walletId) {
        Optional<Wallet> optionalWallet = walletRepository.findById(walletId);
        
        if (optionalWallet.isEmpty()) {
            throw new WalletNotFoundException("Wallet not found.");
        }

        Wallet wallet = optionalWallet.get();
        return new WalletResponse(wallet.getId(), wallet.getBalance());
    }
}
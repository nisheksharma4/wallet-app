package com.nsdev.walletapp.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WalletResponse {

    private UUID walletId;
    private BigDecimal balance;
}
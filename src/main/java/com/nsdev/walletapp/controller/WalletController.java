package com.nsdev.walletapp.controller;

import com.nsdev.walletapp.dto.WalletRequest;
import com.nsdev.walletapp.dto.WalletResponse;
import com.nsdev.walletapp.service.WalletService;
import com.nsdev.walletapp.util.ResponseStructure;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Validated
public class WalletController {

	@Autowired
	private WalletService walletService;


	@PostMapping("/wallet")
	public ResponseEntity<ResponseStructure<WalletResponse>> handleWalletOperation(
			@Valid @RequestBody WalletRequest request) {
		WalletResponse response = walletService.processOperation(request);
		ResponseStructure<WalletResponse> result = new ResponseStructure<>();
		result.setSuccess(true);
		result.setMessage("Operation completed successfully.");
		result.setData(response);

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/wallets/{walletId}")
	public ResponseEntity<ResponseStructure<WalletResponse>> getWalletBalance(@PathVariable UUID walletId) {

		WalletResponse response = walletService.getWalletBalance(walletId);

		ResponseStructure<WalletResponse> result = new ResponseStructure<>();
		result.setSuccess(true);
		result.setMessage("Balance retrieved successfully.");
		result.setData(response);

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
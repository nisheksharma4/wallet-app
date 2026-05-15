package com.nsdev.walletapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsdev.walletapp.dto.WalletRequest;
import com.nsdev.walletapp.dto.WalletResponse;
import com.nsdev.walletapp.util.ResponseStructure;


@RestController
@RequestMapping("/api/v1")
public class WalletController {
	
	
	@PostMapping("/wallet")
	public ResponseEntity<ResponseStructure<WalletResponse>> processOperation(@RequestBody WalletRequest wr) {
		
	}

}

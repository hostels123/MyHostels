package com.hostels.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostels.service.OTPService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/otp")
public class OTPController {
    @Autowired
    private OTPService otpService;

    /*@PostMapping("/send")
    public ResponseEntity<String> sendOTP(@RequestBody String phoneNumber) {
        // Generate OTP, store it, and send it
        String otp = generateOTP();
        // Store OTP in a suitable data store
        otpService.sendOTP(phoneNumber, otp);
        return ResponseEntity.ok("OTP sent successfully");
    }*/

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateOTP(@RequestParam String phoneNumber, @RequestParam String inputOTP) {
        // Retrieve the stored OTP
        String storedOTP = getStoredOTP(phoneNumber);
        // Compare and remove the OTP
        return ResponseEntity.ok(storedOTP.equals(inputOTP));
    }

    private String getStoredOTP(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	private String generateOTP() {
        // Generate a random 6-digit OTP
        return RandomStringUtils.randomNumeric(6);
    }
}

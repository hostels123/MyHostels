package com.hostels.service;

import java.net.http.HttpResponse;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {
	/*@Autowired
    private TwilioRestClient twilioRestClient;

    public void sendOTP(String phoneNumber, String otp) {
    	Message message = Message.creator(
    		    new PhoneNumber("+15023783055"),
    		    new PhoneNumber("+19553745527"),
    		    "Your OTP is: " + otp
    		).create(twilioRestClient);
    }
    
    public String generateOTP() {	
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
    */
    
    /*public void sendOTPSMS(String phoneNumber, String otp) {
    	HttpResponse response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
    			  .header("authorization", "YOUR_API_KEY")
    			  .header("Content-Type", "application/x-www-form-urlencoded")
    			  .body("variables_values=5599&route=otp&numbers=9999999999,8888888888,7777777777")
    			  .asString();
    }*/
}

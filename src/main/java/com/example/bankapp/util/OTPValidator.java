package com.example.bankapp.util;
import org.jboss.aerogear.security.otp.Totp;

public class OTPValidator {

    public static boolean verifyCode(String secret, String otp) {
        Totp totp = new Totp(secret);
        return totp.verify(otp);
    }
}

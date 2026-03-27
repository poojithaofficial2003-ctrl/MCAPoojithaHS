package com.example.bankapp.util;
import org.jboss.aerogear.security.otp.api.Base32;

public class SecretKeyGenerator {

    public static String generateSecret() {
        return Base32.random();
    }
}

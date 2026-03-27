package com.example.bankapp.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.ByteArrayOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class QRCodeUtil {

    // ✅ Method 1: Generate otpauth URL
    public static String getQRCodeURL(String user, String company, String secret) {
        return "otpauth://totp/"
                + URLEncoder.encode(company + ":" + user, StandardCharsets.UTF_8)
                + "?secret=" + secret
                + "&issuer=" + URLEncoder.encode(company, StandardCharsets.UTF_8);
    }

    // ✅ Method 2: Generate QR Image (Base64)
    public static String generateQRCodeImage(String text) throws Exception {

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
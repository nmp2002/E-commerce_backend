package com.ttisv.service.system;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VnPayService {

    @Value("${vnpay.tmncode}")
    private String vnpTmnCode;

    @Value("${vnpay.hashSecret}")
    private String vnpHashSecret;

    @Value("${vnpay.url}")
    private String vnpUrl;

    @Value("${vnpay.returnUrl}")
    private String vnpReturnUrl;

    public String createPaymentUrl(Long orderId, Double amount) throws Exception {
        System.out.println("VNPAY URL: " + vnpUrl);
        System.out.println("VNPAY TMN Code: " + vnpTmnCode);
        System.out.println("VNPAY Hash Secret: " + vnpHashSecret);
        System.out.println("VNPAY Return URL: " + vnpReturnUrl);

        String vnpVersion = "2.1.0";
        String vnpCommand = "pay";
        String orderType = "billpayment";
        
        String vnpTxnRef = String.valueOf(orderId);
        String vnpIpAddr = "127.0.0.1"; 
        String vnpLocale = "vn";
        String vnpCurrCode = "VND";
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnpCreateDate = formatter.format(new Date());
        
        Map<String, String> vnpParams = new HashMap<>();
        vnpParams.put("vnp_Version", vnpVersion);
        vnpParams.put("vnp_Command", vnpCommand);
        vnpParams.put("vnp_TmnCode", vnpTmnCode);
        vnpParams.put("vnp_Amount", String.valueOf(Math.round(amount * 100)));
        vnpParams.put("vnp_CurrCode", vnpCurrCode);
        vnpParams.put("vnp_TxnRef", vnpTxnRef);
        vnpParams.put("vnp_OrderInfo", "Thanh toán đặt hàng - Order ID: " + orderId);
        vnpParams.put("vnp_OrderType", orderType);
        vnpParams.put("vnp_ReturnUrl", vnpReturnUrl);
        vnpParams.put("vnp_IpAddr", vnpIpAddr);
        vnpParams.put("vnp_Locale", vnpLocale);
        vnpParams.put("vnp_CreateDate", vnpCreateDate);
        
        // Sắp xếp các tham số theo thứ tự chữ cái
        List<String> fieldNames = new ArrayList<>(vnpParams.keySet());
        Collections.sort(fieldNames);
        
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        
        for (String fieldName : fieldNames) {
            String fieldValue = vnpParams.get(fieldName);
            if (fieldValue != null && !fieldValue.isEmpty()) {
                hashData.append(fieldName).append('=')
                        .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()))
                        .append('&');
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()))
                        .append('=')
                        .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()))
                        .append('&');
            }
        }
        
        String queryUrl = query.substring(0, query.length() - 1); 
        String vnpSecureHash = hmacSHA512(vnpHashSecret, hashData.substring(0, hashData.length() - 1)); 
        String paymentUrl = vnpUrl + "?" + queryUrl + "&vnp_SecureHash=" + vnpSecureHash;

        System.out.println("Generated Payment URL: " + paymentUrl); 
        return paymentUrl;
    }

    public String hmacSHA512(String key, String data) throws Exception {
        Mac hmac512 = Mac.getInstance("HmacSHA512");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
        hmac512.init(secretKeySpec);
        byte[] bytes = hmac512.doFinal(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder hash = new StringBuilder();
        for (byte b : bytes) {
            hash.append(String.format("%02x", b));
        }
        return hash.toString();
    }
}

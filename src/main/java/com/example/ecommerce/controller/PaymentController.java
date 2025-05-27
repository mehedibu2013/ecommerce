package com.example.ecommerce.controller;

import com.example.ecommerce.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @GetMapping("/checkout")
    public String checkout(@RequestParam String productName,
                           @RequestParam BigDecimal amount,
                           @RequestParam String currency) throws Exception {
        return stripeService.createPaymentLink(amount, currency, productName);
    }
}
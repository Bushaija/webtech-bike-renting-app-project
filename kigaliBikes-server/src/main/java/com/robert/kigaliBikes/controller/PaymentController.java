package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.PaymentRequest;
import com.robert.kigaliBikes.enums.PaymentStatus;
import com.robert.kigaliBikes.model.Payment;
import com.robert.kigaliBikes.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment processPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPayment(paymentRequest.getUserId(), paymentRequest.getRideId(), paymentRequest.getAmount());
    }

    @PutMapping("/{paymentId}/status")
    public Payment updatePaymentStatus(@PathVariable Long paymentId, @RequestParam PaymentStatus newStatus) {
        return paymentService.updatePaymentStatus(paymentId, newStatus);
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/ride/{rideId}")
    public List<Payment> getPaymentsForRide(@PathVariable Long rideId) {
        return paymentService.getPaymentsForRide(rideId);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUser(@PathVariable Long userId) {
        return paymentService.getPaymentsByUser(userId);
    }
}

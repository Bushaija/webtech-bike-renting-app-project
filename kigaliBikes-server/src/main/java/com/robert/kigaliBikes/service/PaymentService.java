package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.PaymentStatus;
import com.robert.kigaliBikes.exception.PaymentNotFoundException;
import com.robert.kigaliBikes.model.Payment;
import com.robert.kigaliBikes.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService implements PaymentUI{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public Payment processPayment(Long userId, Long rideId, BigDecimal amount) {
        try {
            // Implement payment processing logic here if needed

            Payment payment = new Payment();
            payment.setAmount(amount);
            // Set other payment details such as status, user, and ride based on the provided parameters
            // ...

            return paymentRepository.save(payment);
        } catch (Exception e) {
            handleException("Error processing payment", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Payment updatePaymentStatus(Long paymentId, PaymentStatus newStatus) {
        try {
            validatePaymentId(paymentId);

            Payment payment = getPaymentById(paymentId);
            payment.setStatus(newStatus);

            return payment;
        } catch (Exception e) {
            handleException("Error updating payment status", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Payment getPaymentById(Long paymentId) {
        try {
            validatePaymentId(paymentId);

            return paymentRepository.findById(paymentId)
                    .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + paymentId));
        } catch (Exception e) {
            handleException("Error getting payment by ID", e);
            return null; // or throw a custom exception if needed
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<Payment> getPaymentsForRide(Long rideId) {
        // Implement logic to retrieve payments for a specific ride
        // ...

        return paymentRepository.findByRideId(rideId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Payment> getPaymentsByUser(Long userId) {
        // Implement logic to retrieve payments for a specific user
        // ...

        return paymentRepository.findByUserId(userId);
    }

    private void validatePaymentId(Long paymentId) {
        if (paymentId == null || paymentId <= 0) {
            throw new IllegalArgumentException("Invalid payment ID: " + paymentId);
        }
    }

    private void handleException(String message, Exception e) {
        // Log the exception and perform additional error handling if needed
        System.err.println(message + ": " + e.getMessage());
    }
}

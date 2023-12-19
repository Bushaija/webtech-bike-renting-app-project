package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.PaymentStatus;
import com.robert.kigaliBikes.model.Payment;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentUI {

    /**
     * Process a payment for a ride by the specified user.
     * @param userId The ID of the user making the payment.
     * @param rideId The ID of the ride for which the payment is being processed.
     * @param amount The amount to be paid for the ride.
     * @return The created payment entity.
     */
    Payment processPayment(Long userId, Long rideId, BigDecimal amount);

    /**
     * Update the payment status for a specific payment.
     * @param paymentId The ID of the payment to be updated.
     * @param newStatus The new payment status.
     * @return The updated payment entity.
     */
    Payment updatePaymentStatus(Long paymentId, PaymentStatus newStatus);

    /**
     * Retrieve payment details by payment ID.
     * @param paymentId The ID of the payment to retrieve.
     * @return The payment entity with the specified ID.
     */
    Payment getPaymentById(Long paymentId);

    /**
     * Retrieve a list of payments associated with a specific ride.
     * @param rideId The ID of the ride for which payments are to be retrieved.
     * @return A list of payment entities associated with the ride.
     */
    List<Payment> getPaymentsForRide(Long rideId);

    /**
     * Retrieve a list of payments made by a specific user.
     * @param userId The ID of the user for whom payments are to be retrieved.
     * @return A list of payment entities made by the user.
     */
    List<Payment> getPaymentsByUser(Long userId);
}

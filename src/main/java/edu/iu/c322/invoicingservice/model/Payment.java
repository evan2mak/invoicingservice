package edu.iu.c322.invoicingservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    @NotEmpty(message = "Payment method cannot be empty.")
    private String method;
    @NotEmpty(message = "Credit card number cannot be empty.")
    private String number;
    @Valid
    @OneToOne
    private BillingAddress billingAddress;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(method, payment.getMethod()) && Objects.equals(number, payment.getNumber()) && Objects.equals(billingAddress, payment.getBillingAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, number, billingAddress);
    }
}

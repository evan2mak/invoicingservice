package edu.iu.c322.invoicingservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    private int orderId;
    @NotEmpty
    private String orderPlaced;
    private double total;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private InvoiceItem invoiceItem;
    @ManyToOne(cascade = CascadeType.ALL)
    @Valid
    private Payment payment;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;
        return Double.compare(invoice.getTotal(), getTotal()) == 0 && Objects.equals(getOrderPlaced(), invoice.getOrderPlaced()) && Objects.equals(getInvoiceItem(), invoice.getInvoiceItem()) && Objects.equals(getPayment(), invoice.getPayment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderPlaced(), getTotal(), getInvoiceItem(), getPayment());
    }
}

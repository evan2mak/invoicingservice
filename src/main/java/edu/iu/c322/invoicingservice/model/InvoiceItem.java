package edu.iu.c322.invoicingservice.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceItemId;
    @NotEmpty
    private String status;
    @OneToMany
    @Valid
    private List<Item> items;
    @NotEmpty
    private String on;
    @ManyToOne
    @Valid
    private Address address;

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItem that)) return false;
        return Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getOn(), that.getOn()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getItems(), getOn(), getAddress());
    }
}

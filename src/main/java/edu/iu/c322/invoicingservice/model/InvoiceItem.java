package edu.iu.c322.invoicingservice.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceItemId;
    @NotEmpty
    private String status;
    @OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<ItemInv> items;
    @NotEmpty
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
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

    public List<ItemInv> getItems() {
        return items;
    }

    public void setItems(List<ItemInv> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return getInvoiceItemId() == that.getInvoiceItemId() && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceItemId(), getStatus(), getItems(), getDate(), getAddress());
    }
}

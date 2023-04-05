package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.Invoice;
import edu.iu.c322.invoicingservice.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryInvoiceRepository {
    private List<Invoice> invoices = new ArrayList<>();
    public Invoice findByOrderId(int orderId) {
        return invoices.stream().filter(invoice -> invoice.getOrderId() == orderId).findFirst().orElse(null);
    }

    public void create(Invoice invoice){
        int itemId = 1;
        for (Item item : invoice.getInvoiceItem().getItems()) {
            item.setItemId(itemId);
            itemId++;
        }
        invoices.add(invoice);
    }

    public void update(int orderId, int itemId, String status){
        Invoice invoice = getInvoiceById(orderId);
        if (invoice != null) {
            Item item = invoice.getInvoiceItem().getItems().stream().filter(i -> i.getItemId() == itemId).findFirst().orElse(null);
            if (item != null) {
                item.setStatus(status);
            }
            else {
                throw new IllegalStateException("Item ID is not valid.");
            }
        }
        else {
            throw new IllegalStateException("Order ID is not valid.");
        }
    }

    private Invoice getInvoiceById(int orderId) {
        return invoices.stream().filter(x -> x.getOrderId() == orderId).findAny().orElse(null);
    }
}

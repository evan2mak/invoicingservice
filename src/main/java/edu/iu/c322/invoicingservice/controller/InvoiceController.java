package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.Invoice;
import edu.iu.c322.invoicingservice.model.ItemInv;
import edu.iu.c322.invoicingservice.model.UpdateRequest;
import edu.iu.c322.invoicingservice.repository.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findByOrderId(@PathVariable int orderId) {
        Invoice invoice = repository.findByOrderId(orderId);
        if (invoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with this ID does not exist in the system.");
        }
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("/{orderId}")
    public void update(@Valid @RequestBody UpdateRequest request) {
        Invoice invoice = repository.findByOrderId(request.getOrderId());
        if (invoice != null) {
            boolean itemFound = false;
            for (ItemInv item : invoice.getInvoiceItem().getItems()) {
                if (item.getItemId() == request.getItemId()) {
                    item.setStatus(request.getStatus());
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                throw new IllegalStateException("Item ID is not valid.");
            }
            repository.save(invoice);
        }
        else {
            throw new IllegalStateException("Order ID is not valid.");
        }
    }

    @PostMapping
    public void create(@Valid @RequestBody Invoice invoice) {
        repository.save(invoice);
    }
}

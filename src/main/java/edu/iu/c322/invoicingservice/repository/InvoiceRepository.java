package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
    Invoice findByOrderId(int orderId);
}

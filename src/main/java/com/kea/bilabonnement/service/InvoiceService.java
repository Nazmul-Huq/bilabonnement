package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CheckAddAlarm;

import java.util.List;

/**
 * Author Nazmul
 */

public class InvoiceService {

    // make necessary objects
    private final BilabonnementCRUD<Invoice> invoiceRepo;
    private final CheckAddAlarm<Invoice> invoiceCheckAddAlarm;

    public InvoiceService(BilabonnementCRUD<Invoice> invoiceRepo, CheckAddAlarm<Invoice> invoiceCheckAddAlarm) {
        this.invoiceRepo = invoiceRepo;
        this.invoiceCheckAddAlarm = invoiceCheckAddAlarm;
    }

    // make an invoice
    public boolean makeInvoice(Invoice invoice) {
        return invoiceRepo.addEntity(invoice);
    }

    // get and return an invoice by invoice number
    public Invoice getInvoiceById(int invoiceNumber) {
        return invoiceRepo.getSingleEntityById(invoiceNumber);
    }

    // get and return a list of unpaid invoices
    public List<Invoice> getUnpaidInvoice() {
        return invoiceCheckAddAlarm.getUnpaidEntities();
    }
} // class ends here

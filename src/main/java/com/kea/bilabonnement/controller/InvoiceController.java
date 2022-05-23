package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CheckAddAlarm;
import com.kea.bilabonnement.repo.InvoiceRepo;
import com.kea.bilabonnement.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    //instantiate necessary objects
    private final BilabonnementCRUD<Invoice> invoiceRepo = new InvoiceRepo();
    private final CheckAddAlarm<Invoice> invoiceCheckAddAlarm = new InvoiceRepo();
    private final InvoiceService invoiceService = new InvoiceService(invoiceRepo, invoiceCheckAddAlarm);

    // show make invoice page
    @GetMapping("/make-invoice")
    public String makeInvoicePage(){
        return "/invoice/make-invoice";
    }

    // handle make invoice
    @PostMapping("/make-invoice")
    public String makeInvoice(@ModelAttribute Invoice invoice) {
        if (invoiceService.makeInvoice(invoice)) {
            return "redirect:/invoice/succeess-invoice";
        } else {
            return "redirect:/error";
        }
    }

    // show the invoice detail page where an invoice id can be submitted to see its detail
    @GetMapping("/see-an-invoice-detail")
    public String seeAnInvoiceDetailPage(){
        return "/invoice/see-an-invoice-detail-form";
    }

    // handle the invoice detail request
    @PostMapping("/see-an-invoice-detail")
    public String seeAnInvoiceDetail(@RequestParam int invoiceNumber, Model model){
        model.addAttribute("individualInvoice", invoiceService.getInvoiceById(invoiceNumber));
        return "/invoice/see-an-invoice-detail";
    }

    // show all unpaid invoices
    @GetMapping("/see-all-due-invoice")
    public String seeAllDueInvoices(Model model){
        model.addAttribute("unpaidInvoices", invoiceService.getUnpaidInvoice());
        return "/invoice/see-all-due-invoice";
    }

}// class ends here

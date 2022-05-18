package com.kea.bilabonnement.model;

import java.util.Date;

/**
 * Author Nazmul
 */

public class Payment {
    private int id;
    private Date invoiceDate;
    private Date payDate;
    private int invoiceNumber;

    // default constructor
    public Payment() {
    }

    // constructor without id attribute
    public Payment(Date invoiceDate, Date payDate, int invoiceNumber) {
        this.invoiceDate = invoiceDate;
        this.payDate = payDate;
        this.invoiceNumber = invoiceNumber;
    }

    // constructor with all attribute

    public Payment(int id, Date invoiceDate, Date payDate, int invoiceNumber) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.payDate = payDate;
        this.invoiceNumber = invoiceNumber;
    }

    public int getId() {
        return id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", invoiceDate=" + invoiceDate +
                ", payDate=" + payDate +
                ", invoiceNumber=" + invoiceNumber +
                '}';
    }

} // class ends here

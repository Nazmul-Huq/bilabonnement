package com.kea.bilabonnement.model;

import java.util.Date;

/**
 * Author Nazmul
 */

public class InvoicePaymentDate {

    private Date paymentDeadline;
    private Date paymentDate;

    // default constructor
    public InvoicePaymentDate() {
    }

    // all args constructor
    public InvoicePaymentDate(Date paymentDeadline, Date paymentDate) {
        this.paymentDeadline = paymentDeadline;
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "InvoicePaymentDate{" +
                "paymentDeadline=" + paymentDeadline +
                ", paymentDate=" + paymentDate +
                '}';
    }
}

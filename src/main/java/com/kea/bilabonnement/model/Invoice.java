package com.kea.bilabonnement.model;

import java.sql.Date;

/**
 * Author Nazmul
 */

public class Invoice {

    private int invoiceNumber;
    private Date invoiceDate;
    private String invoiceReceiver;
    private String invoiceType;
    private int paymentAmount;
    private Date paymentDeadline;
    private int carRegNumber;
    private int employeeId;
    private int agreementNumber;
    private int customerId;

    // default constructor
    public Invoice() {
    }

    // constructor without invoiceNumber attribute
    public Invoice(Date invoiceDate, String invoiceReceiver, String invoiceType, int paymentAmount, Date paymentDeadline, int carRegNumber, int employeeId, int agreementNumber, int customerId) {
        this.invoiceDate = invoiceDate;
        this.invoiceReceiver = invoiceReceiver;
        this.invoiceType = invoiceType;
        this.paymentAmount = paymentAmount;
        this.paymentDeadline = paymentDeadline;
        this.carRegNumber = carRegNumber;
        this.employeeId = employeeId;
        this.agreementNumber = agreementNumber;
        this.customerId = customerId;
    }

    // constructor with all attributes
    public Invoice(int invoiceNumber, Date invoiceDate, String invoiceReceiver, String invoiceType, int paymentAmount, Date paymentDeadline, int carRegNumber, int employeeId, int agreementNumber, int customerId) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceReceiver = invoiceReceiver;
        this.invoiceType = invoiceType;
        this.paymentAmount = paymentAmount;
        this.paymentDeadline = paymentDeadline;
        this.carRegNumber = carRegNumber;
        this.employeeId = employeeId;
        this.agreementNumber = agreementNumber;
        this.customerId = customerId;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceReceiver() {
        return invoiceReceiver;
    }

    public void setInvoiceReceiver(String invoiceReceiver) {
        this.invoiceReceiver = invoiceReceiver;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(int agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", invoiceDate=" + invoiceDate +
                ", invoiceReceiver='" + invoiceReceiver + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentDeadline=" + paymentDeadline +
                ", carRegNumber=" + carRegNumber +
                ", employeeId=" + employeeId +
                ", agreementNumber=" + agreementNumber +
                ", customerId=" + customerId +
                '}';
    }

} // class ends here

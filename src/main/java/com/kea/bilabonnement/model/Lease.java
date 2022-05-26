package com.kea.bilabonnement.model;

import java.sql.Date;

/**
 * Author Nazmul
 */

public class Lease {

    private int id;
    private int leasingPrice;
    private String leasingCompany;
    private Date leasingStartDate;
    private Date leasingFinishDate;
    private String regCertificate;
    private int carRegNumber;

    // default constructor
    public Lease() {
    }

    // constructor without id
    public Lease(int leasingPrice, String leasingCompany, Date leasingStartDate, Date leasingFinishDate, String regCertificate, int carRegNumber) {
        this.leasingPrice = leasingPrice;
        this.leasingCompany = leasingCompany;
        this.leasingStartDate = leasingStartDate;
        this.leasingFinishDate = leasingFinishDate;
        this.regCertificate = regCertificate;
        this.carRegNumber = carRegNumber;
    }

    // all args constructor
    public Lease(int id, int leasingPrice, String leasingCompany, Date leasingStartDate, Date leasingFinishDate, String regCertificate, int carRegNumber) {
        this.id = id;
        this.leasingPrice = leasingPrice;
        this.leasingCompany = leasingCompany;
        this.leasingStartDate = leasingStartDate;
        this.leasingFinishDate = leasingFinishDate;
        this.regCertificate = regCertificate;
        this.carRegNumber = carRegNumber;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeasingPrice() {
        return leasingPrice;
    }

    public void setLeasingPrice(int leasingPrice) {
        this.leasingPrice = leasingPrice;
    }

    public String getLeasingCompany() {
        return leasingCompany;
    }

    public void setLeasingCompany(String leasingCompany) {
        this.leasingCompany = leasingCompany;
    }

    public Date getLeasingStartDate() {
        return leasingStartDate;
    }

    public void setLeasingStartDate(Date leasingStartDate) {
        this.leasingStartDate = leasingStartDate;
    }

    public Date getLeasingFinishDate() {
        return leasingFinishDate;
    }

    public void setLeasingFinishDate(Date leasingFinishDate) {
        this.leasingFinishDate = leasingFinishDate;
    }

    public String getRegCertificate() {
        return regCertificate;
    }

    public void setRegCertificate(String regCertificate) {
        this.regCertificate = regCertificate;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    // to string
    @Override
    public String toString() {
        return "Lease{" +
                "id=" + id +
                ", leasingPrice=" + leasingPrice +
                ", leasingCompany='" + leasingCompany + '\'' +
                ", leasingStartDate=" + leasingStartDate +
                ", leasingFinishDate=" + leasingFinishDate +
                ", regCertificate='" + regCertificate + '\'' +
                ", carRegNumber=" + carRegNumber +
                '}';
    }
}

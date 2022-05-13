package com.kea.bilabonnement.model;

public class RegReport {

    //Attributes
    private int regReportNumber;
    private int regReportDate;
    private int regReportEmployeeId;
    private int regReportCarRegNr;

    //Default Constructor
    public RegReport() {
    }

    //Constructor without reReportNumber
    public RegReport(int regReportDate, int regReportEmployeeId, int regReportCarRegNr) {
        this.regReportDate = regReportDate;
        this.regReportEmployeeId = regReportEmployeeId;
        this.regReportCarRegNr = regReportCarRegNr;
    }

    //Constructor
    public RegReport(int regReportNumber, int regReportDate, int regReportEmployeeId, int regReportCarRegNr) {
        this.regReportNumber = regReportNumber;
        this.regReportDate = regReportDate;
        this.regReportEmployeeId = regReportEmployeeId;
        this.regReportCarRegNr = regReportCarRegNr;
    }

    //Getters
    public int getRegReportNumber() {
        return regReportNumber;
    }

    public int getRegReportDate() {
        return regReportDate;
    }

    public int getRegReportEmployeeId() {
        return regReportEmployeeId;
    }

    public int getRegReportCarRegNr() {
        return regReportCarRegNr;
    }


    //toString
    @Override
    public String toString() {
        return "RegReport{" +
                "regReportNumber=" + regReportNumber +
                ", regReportDate=" + regReportDate +
                ", regReportEmployeeId=" + regReportEmployeeId +
                ", regReportCarRegNr=" + regReportCarRegNr +
                '}';
    }
}

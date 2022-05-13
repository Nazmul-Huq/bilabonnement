package com.kea.bilabonnement.model;

public class ConditionReport {

    //Attributes
    private int conditionNumber;
    private int conditionDate;
    private String conditionDescription;
    private int conditionLevel;
    private int conditionEmployeeId;
    private int conditionCarRegNr;

    //Default Constructor
    public ConditionReport() {
    }

    //Constructor without ConditionNumber
    public ConditionReport(int conditionDate, String conditionDescription, int conditionLevel, int conditionEmployeeId, int conditionCarRegNr) {
        this.conditionDate = conditionDate;
        this.conditionDescription = conditionDescription;
        this.conditionLevel = conditionLevel;
        this.conditionEmployeeId = conditionEmployeeId;
        this.conditionCarRegNr = conditionCarRegNr;
    }

    //Constructor
    public ConditionReport(int conditionNumber, int conditionDate, String conditionDescription, int conditionLevel, int conditionEmployeeId, int conditionCarRegNr) {
       this.conditionNumber = conditionNumber;
       this.conditionDate = conditionDate;
       this.conditionDescription =conditionDescription;
       this.conditionLevel = conditionLevel;
       this.conditionEmployeeId = conditionEmployeeId;
       this.conditionCarRegNr = conditionCarRegNr;
    }

    //Getters And Setters
    public int getConditionNumber() {
        return conditionNumber;
    }

    public int getConditionDate() {
        return conditionDate;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public int getConditionLevel() {
        return conditionLevel;
    }

    public int getConditionEmployeeId() {
        return conditionEmployeeId;
    }

    public int getConditionCarRegNr() {
        return conditionCarRegNr;
    }


    //toString

    @Override
    public String toString() {
        return "ConditionReport{" +
                "conditionNumber=" + conditionNumber +
                ", date=" + conditionDate +
                ", conditionDescription='" + conditionDescription + '\'' +
                ", conditionLevel=" + conditionLevel +
                ", conditionEmployeeId=" + conditionEmployeeId +
                ", conditionCarRegNr=" + conditionCarRegNr +
                '}';
    }
}
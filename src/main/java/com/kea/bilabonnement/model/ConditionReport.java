package com.kea.bilabonnement.model;

public class ConditionReport {

    //Attributes
    private int conditionNumber;
    private int date;
    private String conditionDescription;
    private int conditionLevel;
    private int conditionEmployeeId;
    private int conditionCarRegNr;

    //Constructor
    public ConditionReport(int conditionNumber, int date, String conditionDescription, int conditionLevel, int conditionEmployeeId, int conditionCarRegNr) {
       this.conditionNumber = conditionNumber;
       this.date = date;
       this.conditionDescription =conditionDescription;
       this.conditionLevel = conditionLevel;
       this.conditionEmployeeId = conditionEmployeeId;
       this.conditionCarRegNr = conditionCarRegNr;
    }

    //Getters And Setters
    public int getConditionNumber() {
        return conditionNumber;
    }

    public int getDate() {
        return date;
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
                ", date=" + date +
                ", conditionDescription='" + conditionDescription + '\'' +
                ", conditionLevel=" + conditionLevel +
                ", conditionEmployeeId=" + conditionEmployeeId +
                ", conditionCarRegNr=" + conditionCarRegNr +
                '}';
    }
}
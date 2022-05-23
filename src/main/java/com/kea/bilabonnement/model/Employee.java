package com.kea.bilabonnement.model;

import com.kea.bilabonnement.enums.Department;

import java.util.Date;

/**
 * Author Nazmul
 */

public class Employee extends Person {

    private Date hireDate;
    private Department department;

    // default constructor
    public Employee() {
    }

    // constructor without id
    public Employee(String name, int cprNumber, String username, String password, Date hireDate, Department department) {
        super(name, cprNumber, username, password);
        this.hireDate = hireDate;
        this.department = department;
    }

    // all args constructor
    public Employee(int id, String name, int cprNumber, String username, String password, Date hireDate, Department department) {
        super(id, name, cprNumber, username, password);
        this.hireDate = hireDate;
        this.department = department;
    }

    // getters and setters

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    //to string

    @Override
    public String toString() {
        return "Employee{" +
                "hireDate=" + hireDate +
                ", department=" + department +
                "} " + super.toString();
    }
}

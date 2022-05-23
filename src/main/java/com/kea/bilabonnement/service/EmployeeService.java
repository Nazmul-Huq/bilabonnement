package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Employee;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

/**
 * Author Nazmul
 */

public class EmployeeService {

    private final BilabonnementCRUD<Employee> employeeRepo;

    public EmployeeService(BilabonnementCRUD<Employee> employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public boolean addEmployee(Employee employee) {
        return employeeRepo.addEntity(employee);
    }
}

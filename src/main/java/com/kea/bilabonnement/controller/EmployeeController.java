package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.enums.Department;
import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.model.Employee;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.EmployeeRepo;
import com.kea.bilabonnement.repo.LoginRepoImpl;
import com.kea.bilabonnement.service.EmployeeService;
import com.kea.bilabonnement.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final BilabonnementCRUD<Employee> employeeRepo = new EmployeeRepo();
    private final EmployeeService employeeService = new EmployeeService(employeeRepo);
    private final LoginRepoImpl loginRepo = new LoginRepoImpl();
    private final LoginService loginService = new LoginService(loginRepo);

    // show employee registration page
    @GetMapping("/add-employee")
    public String addEmployee() {
        return "/employee/add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployeeHandler(
            @RequestParam String name,
            @RequestParam int cprNumber,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Date hireDate,
            @RequestParam String department
    ) {

        Employee employee = new Employee(name, cprNumber, username, password, hireDate, Department.valueOf(department));
        if (employeeService.addEmployee(employee)) {
            return "redirect:/employee/login-employee";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/login-employee")
    public String loginEmployee(){
        return "/employee/login-employee";
    }


    @PostMapping("/login-employee")
    public String loginEmployeeHandler(@RequestParam String username, @RequestParam String password){
        int isLoginValid = loginService.verifyEmployeeLogin(username, password);
        if (isLoginValid != 0) {
            return "redirect:/employee/profile-employee";
        } else {
            return "redirect:/employee/login-employee";
        }
    }


    @GetMapping("/profile-employee")
    public String profileCustomer(){
        return "/employee/profile-employee";
    }
}

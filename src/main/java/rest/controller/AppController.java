package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.Employee;
import rest.exeption_handling.EmployeeIncorrectData;
import rest.exeption_handling.NoSuchEmployeeException;
import rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee emp = employeeService.getEmployee(id);
        if (emp == null) {
            throw new NoSuchEmployeeException("There is no employee with ID=" + id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        employeeService.saveEmployee(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        employeeService.saveEmployee(emp);
        return emp;
    }
}

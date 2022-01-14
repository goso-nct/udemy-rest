package rest.dao;

import rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee emp);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}

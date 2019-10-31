package org.hxd.service;

import org.hxd.entity.Employee;

public interface IEmployeeService {

    void addEmployee(Employee employee);

    Employee findEmpById(int empId);

    void modifyEmpById(Employee employee);

    int removeEmpById(int empId);
}

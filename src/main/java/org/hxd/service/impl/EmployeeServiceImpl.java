package org.hxd.service.impl;

import org.hxd.entity.Employee;
import org.hxd.mapper.IEmployeeMapper;
import org.hxd.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private IEmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        // System.out.println(5 / 0); 测试事务，当开启此注释时，事务便会回滚，数据不会插入到数据库中
        employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee findEmpById(int empId) {
        return employeeMapper.findEmpById(empId);
    }

    @Override
    public void modifyEmpById(Employee employee) {
        employeeMapper.modifyEmpById(employee);
    }

    @Override
    public int removeEmpById(int empId) {
        return employeeMapper.removeEmpById(empId);
    }
}

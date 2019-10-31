package org.hxd.mapper;

import org.apache.ibatis.annotations.Param;
import org.hxd.entity.Employee;

public interface IEmployeeMapper {

    void addEmployee(Employee employee);

    Employee findEmpById(@Param("empId") int empId);

    void modifyEmpById(Employee employee);

    int removeEmpById(@Param("empId") int empId);
}

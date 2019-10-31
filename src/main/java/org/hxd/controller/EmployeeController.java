package org.hxd.controller;

import org.hxd.entity.Employee;
import org.hxd.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    /**
     * 新增员工
     * @return 新增的员工信息
     */
    @RequestMapping("/addEmployee")
    @ResponseBody
    public Employee addEmployee(){
        Employee employee = new Employee();
        employee.setEmpName("翠花");
        employee.setEmpAge(18);
        employee.setEmpSex("女");
        employeeService.addEmployee(employee);
        return employee;
    }

    /**
     * 根据员工id查找员工
     * @return 员工信息
     */
    @RequestMapping("/findEmpById")
    @ResponseBody
    public Employee findEmpById(){
        Employee employee = employeeService.findEmpById(3);
        return employee;
    }

    /**
     * 根据员工id修改员工姓名
     * @return 员工信息
     */
    @RequestMapping("/modifyEmpById")
    @ResponseBody
    public String modifyEmpById(){
        Employee employee = employeeService.findEmpById(3);
        employee.setEmpName("狗剩");
        employeeService.modifyEmpById(employee);
        return "更新成功" + employee;
    }

    /**
     * 根据员工id删除员工信息
     * @return 删除成功的记录数
     */
    @RequestMapping("/removeEmpById")
    @ResponseBody
    public int removeEmpById(){
        int result = employeeService.removeEmpById(5);
        return result;
    }
}

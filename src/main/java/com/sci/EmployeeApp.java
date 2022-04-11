package com.sci;

import com.sci.dao.DBEmployee;
import com.sci.models.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeApp {

  public static void main(String[] args) {
    DBEmployee dbEmployee = new DBEmployee();

    List<Employee> employeeList = dbEmployee.get();

    for(Employee e : employeeList) {
      System.out.println(e);
    }

//    System.out.println(dbEmployee.get(100));

//    Employee employee = new Employee();
//    employee.setLastName("abdelghany");
//    employee.setEmail("abdelghany@sci.eg");
//    employee.setSalary(151);
//    employee.setCommissionPct(0.5);
//    employee.setDepartmentId(50);
//    employee.setJobId("SH_CLERK");
//    employee.setHireDate(new Date());
//
//    System.out.println(dbEmployee.insert(employee));

//    Employee employee = dbEmployee.get(231);
//
//    employee.setLastName("Mustafa");
//
//    dbEmployee.update(employee);


//    dbEmployee.delete(231);



  }
}

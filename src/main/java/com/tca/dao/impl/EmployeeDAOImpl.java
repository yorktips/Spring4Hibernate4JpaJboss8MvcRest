/**
 * 
 */
package com.tca.dao.impl;

//import com.socan.util.HibernateUtil;

import com.tca.dao.EmployeeDAO;
import com.tca.entity.Employee;
import com.tca.entity.GeneralLicensee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

/**
 * @author Fan
 * @version 1.0
 */

//@Repository
//public class EmployeeDAOImpl implements EmployeeDAO {
//    
//	public EmployeeDAOImpl() {
//    	System.out.println("EmployeeDAOImpl");
//    }
//	
//	@Autowired
//    private HibernateUtil hibernateUtil;
//
//    @Override
//    public long createEmployee(Employee employee) {        
//        return (Long) hibernateUtil.create(employee);
//    }
//
//    
//
//    @Override
//    public List<Employee> getAllEmployees() {        
//        return hibernateUtil.fetchAll(Employee.class);
//    }
//    
//    @Override
//    public Employee getEmployee(long id) {
//        return hibernateUtil.fetchById(id, Employee.class);
//    }
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Employee> getAllEmployees(String employeeName) { 
//		String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
//		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
//		List<Employee> employees = new ArrayList<Employee>();
//		for(Object[] employeeObject: employeeObjects) {
//			Employee employee = new Employee();
//			long id = ((BigInteger) employeeObject[0]).longValue();			
//			int age = (int) employeeObject[1];
//			String name = (String) employeeObject[2];
//			float salary = (float) employeeObject[3];
//			employee.setId(id);
//			employee.setName(name);
//			employee.setAge(age);
//			employee.setSalary(salary);
//			employees.add(employee);
//		}
//		System.out.println(employees);
//		return employees;
//	}
//
//
//}
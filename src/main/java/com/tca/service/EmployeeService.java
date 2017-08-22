
package com.tca.service;
import com.tca.entity.Employee;

import java.util.List;

/**
 * @author Fan
 * @version 1.0
 */
public interface EmployeeService {
	public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);	
	public List<Employee> getAllEmployees(String employeeName);
}

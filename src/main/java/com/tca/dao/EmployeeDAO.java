/**
 * 
 */
package com.tca.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entity.Employee;

/**
 * @author Fan
 * @version 1.0
 */
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    
	//save or saveAndFlush.
	@SuppressWarnings("unchecked")
	@Transactional
	public Employee save(Employee persisted);
    
	@Modifying
	@Transactional
	@Query("delete from Employee where id =:id")
	void delete(@Param("id") long id);
 	
	@Transactional
	void delete(Employee deleted);
    
	@Query("SELECT a FROM Employee a order by id ")
	public List<Employee> getAllEmployees();
    
	public Employee findById(long id);	
    
	@Query("SELECT a FROM Employee a where name like %:name%  order by id ")
	public List<Employee> getAllEmployeesByName(@Param("name") String name);
	
}

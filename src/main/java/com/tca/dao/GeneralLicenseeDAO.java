/**
 * 
 */
package com.tca.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entity.Employee;
import com.tca.entity.GeneralLicensee;

/**
 * @author Fan
 * @version 1.0
 */
public interface GeneralLicenseeDAO extends CrudRepository<GeneralLicensee, Long> {
    
	//save or saveAndFlush.
	@SuppressWarnings("unchecked")
	@Transactional
	public GeneralLicensee save(GeneralLicensee persisted);
    
	@Modifying
	@Transactional
	@Query("delete from GeneralLicensee where id =:id")
	void delete(@Param("id") long id);
 	
	@Transactional
	void delete(GeneralLicensee deleted);
    
	@Query("SELECT a FROM GeneralLicensee a order by id ")
	public List<GeneralLicensee> getAllGeneralLicensee();
    
	public GeneralLicensee findById(long id);	
    
	@Query("SELECT a FROM GeneralLicensee a where name like %:name%  order by id ")
	public List<GeneralLicensee> getAllGeneralLicenseeByName(@Param("name") String name);	
	
    @Query("select A from GeneralLicensee A  where name like %:name% and city like %:city%  and postCode like %:postCode% and address like %:address% order by id")
    Page<GeneralLicensee> getGeneralLicenseePage(@Param("name") String name, @Param("city") String city, @Param("address") String address, @Param("postCode") String postCode, Pageable pageable);
	
}

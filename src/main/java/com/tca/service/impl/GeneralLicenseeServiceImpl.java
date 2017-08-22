package com.tca.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import com.socan.util.HibernateUtil;



import com.tca.controller.EmployeeController;
import com.tca.dao.GeneralLicenseeDAO;
import com.tca.entity.GeneralLicensee;
import com.tca.service.GeneralLicenseeService;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Fan
 * @version 1.0
 */
@Service
@Transactional
public class GeneralLicenseeServiceImpl implements GeneralLicenseeService {

	private static final Logger logger = Logger.getLogger(GeneralLicenseeServiceImpl.class);
	
    @Autowired
    private GeneralLicenseeDAO generalLicenseeDAO;
    
	public GeneralLicenseeServiceImpl() {
		System.out.println("GeneralLicenseeServiceImpl()");
	}

    @Override
    public GeneralLicensee createGeneralLicensee(GeneralLicensee generalLicensee) {
        return generalLicenseeDAO.save(generalLicensee);
    }
    @Override
    public GeneralLicensee updateGeneralLicensee(GeneralLicensee generalLicensee) {
        return generalLicenseeDAO.save(generalLicensee);
    }
    @Override
    public void deleteGeneralLicensee(long id) {
        generalLicenseeDAO.delete(id);
    }
    @Override
    public List<GeneralLicensee> getAllGeneralLicensees() {
        return (List<GeneralLicensee>)generalLicenseeDAO.findAll();
    }
    @Override
    public GeneralLicensee getGeneralLicensee(long id) {
        return generalLicenseeDAO.findOne(id);
    }    
    @Override
    public List<GeneralLicensee> getAllGeneralLicensees(String generalLicenseeName) {
    	return generalLicenseeDAO.getAllGeneralLicenseeByName(generalLicenseeName);
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page<GeneralLicensee> getGeneralLicenseePage(Integer pageNumber,
			Integer pageSize,String sortColumn, String name,String city, String address, String postCode) {
		
		PageRequest request = new PageRequest(pageNumber, pageSize);
		
		if (name==null) name="";
		if (city==null) city="";
		if (address==null) address="";
		if (postCode==null) postCode="";
		
		logger.debug("name=" + name  + ",city=" + city + ", address=" + address + ",postCode=" + postCode);
		System.out.println("name=" + name  + ",city=" + city + ", address=" + address + ",postCode=" + postCode);
		Page<GeneralLicensee> generalLicenseeList = 
				generalLicenseeDAO.getGeneralLicenseePage(name.trim(),city.trim(),address.trim(),postCode.trim(),request);
		
		return generalLicenseeList;
	}
}

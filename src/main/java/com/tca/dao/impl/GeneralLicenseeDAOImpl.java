/**
 * 
 */
package com.tca.dao.impl;
//
//import com.socan.dao.GeneralLicenseeDAO;
//import com.socan.entity.GeneralLicensee;
//import com.socan.util.HibernateUtil;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Fan
// * @version 1.0
// */
//
////@Repository
//public class GeneralLicenseeDAOImpl implements GeneralLicenseeDAO {
//    
//	public GeneralLicenseeDAOImpl() {
//    	System.out.println("GeneralLicenseeDAOImpl");
//    }
//	
//	@Autowired
//    private HibernateUtil hibernateUtil;
//
//    @Override
//    public long createGeneralLicensee(GeneralLicensee generalLicensee) {        
//        return (Long) hibernateUtil.create(generalLicensee);
//    }
//    
//    @Override
//    public GeneralLicensee updateGeneralLicensee(GeneralLicensee generalLicensee) {        
//        return hibernateUtil.update(generalLicensee);
//    }
//    
//    @Override
//    public void deleteGeneralLicensee(long id) {
//        GeneralLicensee generalLicensee = new GeneralLicensee();
//        generalLicensee.setId((int)id);
//        hibernateUtil.delete(generalLicensee);
//    }
//    
//    @Override
//    public List<GeneralLicensee> getAllGeneralLicensees() {        
//        return hibernateUtil.fetchAll(GeneralLicensee.class);
//    }
//    
//    @Override
//    public GeneralLicensee getGeneralLicensee(long id) {
//        return hibernateUtil.fetchById(id, GeneralLicensee.class);
//    }
//
//    @Override
//	public Page<GeneralLicensee> getGeneralLicenseePage(Integer pageNumber, Integer pageSize, String where, String sortColumn){
//		PageRequest request = new PageRequest(pageNumber - 1, pageSize,
//				Sort.Direction.DESC, sortColumn);
//
//		String query = "FROM GeneralLicensee e ";
//		if (!where.trim().equals(""))
//			query += " where " + where + " ";
//
//		if (!sortColumn.trim().equals(""))
//			query += " order by " + sortColumn + " ";
//
//		List<GeneralLicensee>  generalLicenseesList= hibernateUtil.fetchPaging(GeneralLicensee.class,query,pageNumber,pageSize);
//
//		//fetchMaximumPageNumber
//		//final int currentTotal = hibernateUtil.fetchMaximumPageNumber(query, pageSize);
//
//		return new PageImpl(generalLicenseesList, request, 100);
//    }
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<GeneralLicensee> getAllGeneralLicensees(String generalLicenseeName) { 
//		String query = "SELECT e.* FROM GeneralLicensees e WHERE e.name like '%"+ generalLicenseeName +"%'";
//		List<Object[]> generalLicenseeObjects = hibernateUtil.fetchAll(query);
//		List<GeneralLicensee> generalLicensees = new ArrayList<GeneralLicensee>();
//		for(Object[] generalLicenseeObject: generalLicenseeObjects) {
//			GeneralLicensee generalLicensee = new GeneralLicensee();
//			long id = ((BigInteger) generalLicenseeObject[0]).longValue();			
//			int age = (int) generalLicenseeObject[1];
//			String name = (String) generalLicenseeObject[2];
//			float salary = (float) generalLicenseeObject[3];
//			generalLicensee.setId((int)id);
//			generalLicensee.setName(name);
//		}
//		System.out.println(generalLicensees);
//		return generalLicensees;
//	}
//	
//	
//}
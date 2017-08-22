package com.tca.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Fan
 * @version 1.0
 */
//@Repository
//public class HibernateUtil {
//	
//	@Autowired
//    private SessionFactory sessionFactory;
//		
//    public <T> Serializable create(final T entity) {
//        return sessionFactory.getCurrentSession().save(entity);        
//    }
//    
//    public <T> T update(final T entity) {
//        sessionFactory.getCurrentSession().update(entity);   
//        return entity;
//    }
//    
//	public <T> void delete(final T entity) {
//		sessionFactory.getCurrentSession().delete(entity);
//	}
//
//	public <T> void delete(Serializable id, Class<T> entityClass) {
//		T entity = fetchById(id, entityClass);
//		delete(entity);
//	}
//    
//    @SuppressWarnings("unchecked")	
//    public <T> List<T> fetchAll(Class<T> entityClass) {        
//        return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();        
//    }
//  
//    @SuppressWarnings("rawtypes")
//	public <T> List<T> fetchAll(String query) {        
//        return sessionFactory.getCurrentSession().createSQLQuery(query).list();//This is for native sql        
//    }
//    
//    @SuppressWarnings("unchecked")
//	public <T> T fetchById(Serializable id, Class<T> entityClass) {
//        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
//    }
//        
//    @SuppressWarnings("rawtypes")
//	public <T> List<T> fetchPaging(Class<T> klass,String query,int startPage, int pageSize) {
//    	System.out.println("fetchPaging query2=" + query);
///*    	
// * 		//1. use Criteria
//    	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(klass);
//        criteria.setFirstResult((startPage-1)*pageSize).setMaxResults(pageSize);
//        criteria.addOrder(Order.asc("id"));
//        List<T> list = criteria.list();
//        return list;
//*/       
//    	
//    	//2. use sql (rather native sql)
//    	Query q=sessionFactory.getCurrentSession().createQuery(query);
//    	if (startPage<1) startPage=1;
//		q.setFirstResult((startPage-1)*pageSize);
//		q.setMaxResults(pageSize);
//        return q.list();     
//    	
//    }
//    
//    @SuppressWarnings("rawtypes")
//	public <T> int fetchMaximumPageNumber(String query,int pageSize) {
//    	Query q=sessionFactory.getCurrentSession().createQuery(query);
//        int nTotalRows= q.list().size();  
//        if (nTotalRows<=pageSize) return 0;
//        return (int) Math.ceil(((double)nTotalRows/(double)pageSize));
//    }
//    
//    public static int getIntValue(Object t) {
//    	if (t==null)  return 0;
//    	if (t.toString().trim().equals("")) return 0;    	
//    	return Integer.parseInt(t.toString());
//    }
//	
//}

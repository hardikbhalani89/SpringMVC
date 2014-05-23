package com.gogetters.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gogetters.bean.UserBean;

@Repository
public class UserDAOImpl implements UserDAO  {
	
	@Autowired  
	public SessionFactory sessionFactory; 
	
	@Override
	
	public int registerUser(UserBean userBeanObj) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(UserBean.class);
		cr.add(Restrictions.eq("email", userBeanObj.getEmail()));

		

		List<UserBean> rowCount = cr.list();


		 if(rowCount!=null && rowCount.size()==0){
			 
			session.save(userBeanObj);
			return userBeanObj.getId();
		}else{
			session.close();
			Session session1 = sessionFactory.getCurrentSession();
			userBeanObj.setId(rowCount.get(0).getId());
			session1.update(userBeanObj);
			return userBeanObj.getId();	 
		}
		
	}
	@Override
	
	public UserBean signInUser(UserBean userBeanObj) {
		
		System.out.println("in signin use");
		System.out.println("in signin use" +userBeanObj.getEmail());
		System.out.println("in signin use"+userBeanObj.getPassword());
		
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(UserBean.class);
		cr.add(Restrictions.eq("email", userBeanObj.getEmail()));
		cr.add(Restrictions.eq("password", userBeanObj.getPassword()));
		
		 
		List<UserBean> rowCount = cr.list();

	    //System.out.println("Total Count: " + rowCount.get(0) );
		 if(rowCount!=null && rowCount.size()>0){
			 
			 return rowCount.get(0);
		 }
		 else{
			 return null;
		 }
	    
		
	}
}

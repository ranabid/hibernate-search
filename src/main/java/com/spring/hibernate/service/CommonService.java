package com.spring.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.User;

@Service("commonService")
@Transactional
public class CommonService {
	
GenericDao<User> dao;
	
	@Autowired
	public void setDao(GenericDao<User> daoToSet) {
		dao = daoToSet;
		dao.setClazz(User.class);
	}
	
	public void rebuildIndex() throws Exception {
		try {
			dao.rebuildIndex();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List search(String msg) {
		return dao.search(User.class, msg);
		
	}

}

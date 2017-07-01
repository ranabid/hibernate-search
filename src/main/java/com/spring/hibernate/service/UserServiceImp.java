package com.spring.hibernate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.User;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {

	GenericDao<User> dao;
	
	@Autowired
	public void setDao(GenericDao<User> daoToSet) {
		dao = daoToSet;
		dao.setClazz(User.class);
	}
	
	public void createUser(User user) {
		
		if(dao!=null) {
			dao.create(user);
		} else {
			System.out.println("dao is not initilized");
		}
		
	}

}

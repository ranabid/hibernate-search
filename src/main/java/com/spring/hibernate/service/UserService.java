package com.spring.hibernate.service;

import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.User;

public interface UserService {

	public void setDao( GenericDao< User > daoToSet );
	
	public void createUser(User user);
}

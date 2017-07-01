package com.spring.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T extends Serializable> {
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
		System.out.println("CLASS: "+clazz);
	}

	public T findOne(final long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public void create(T entity) {
		getCurrentSession().persist(entity);
		System.out.println("Data saved");
	}
	

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
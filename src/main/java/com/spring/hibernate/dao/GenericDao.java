package com.spring.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T extends Serializable> {
	
	public void create(final T entity);
	public void setClazz(final Class<T> clazzToSet);
	public List search(final Class<T> clazz, String msg);
	public void rebuildIndex() throws InterruptedException;
	

}

package com.spring.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class GenericHibernateDAO<T extends Serializable> 
	extends AbstractHibernateDAO< T > implements GenericDao< T >{

	@Override
	public List<Object> search(Class<T> clazz, String msg) {
		FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
		
		QueryBuilder userQB = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(clazz).get();
		Query fullTextQuery = userQB.keyword().onField("userName").matching(msg).createQuery();
		
		javax.persistence.Query query = fullTextSession.createFullTextQuery(fullTextQuery, clazz);
		
		return (query.getResultList());
	}
	
	public void rebuildIndex() throws InterruptedException {
		FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
		fullTextSession.createIndexer().startAndWait();
	}

}

package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAUtil;

public class DaoGeneric<E> {
	
	public String save(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
			entityManager.persist(entity);
		entityTransaction.commit();
		entityManager.close();
		
		return "";
	}
	
	
	public E merge(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		E ret =	entityManager.merge(entity);
		entityTransaction.commit();
		entityManager.close();
		
		return ret;
	}

	public void delete(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
			entityManager.remove(entity);
		entityTransaction.commit();
		
		entityManager.close();		
	}
	
	public void deleteWithId(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
			Object id = JPAUtil.getPrimaryKey(entity);
			entityManager.createQuery("DELETE FROM " + entity.getClass().getCanonicalName() + " WHERE id = " + id).executeUpdate();
		entityTransaction.commit();
		
		entityManager.close();		
	}
	
	
	
	/*public E list() {
		
		
		
		return E;
	}*/
}

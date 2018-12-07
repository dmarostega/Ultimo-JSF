package br.com.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;
	
	
	//recurso estático..
	//cria EntityManager caso, o mesmo não existir. não duplica 
	static {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory("Ultimo");
		}
	}
	
	public static EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil();		
	}
	

}

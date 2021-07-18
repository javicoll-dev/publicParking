package com.uisrael.publicParking.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.uisrael.publicParking.model.dao.GenericaDao;

public class GenericaDaoImpl<T> implements GenericaDao<T>{

	private Class<T> entityClass;

	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUpublicParking");
	protected EntityManager entityManager;

	// constructores
	public GenericaDaoImpl() {
		entityManager = emf.createEntityManager();//crear conexion
	}

	public GenericaDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		entityManager = emf.createEntityManager();
	}

	
	// Definimos el CRUD
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	public T read(Object id) {
		return this.entityManager.find(entityClass, id);
	}

	public T update(T t) {
		return this.entityManager.merge(t);
	}

	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	// Definir los par�metros
	public void beginTransaction() {
		if (!entityManager.getTransaction().isActive()) //existe conexion activa
			entityManager = emf.createEntityManager(); //crear conexion

		entityManager.getTransaction().begin(); //inicializar transacci�n
	}

	public void commit() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().commit();
	}

	public void rollback() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
	}

	public void closeTransaction() {
		entityManager.close();
	}

	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	public void flush() {
		entityManager.flush();
	}

	/*public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.entityManager.createQuery(cq).getResultList();
	}*/
}
